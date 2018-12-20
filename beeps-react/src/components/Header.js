import React, { Component } from "react";
import { findDOMNode } from "react-dom";
import Axios from "axios";

class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            showCart: false,
            cart: this.props.cartItems,
            mobileSearch: false
        };
    }
    handleCart(e) {
        e.preventDefault();
        this.setState({
            showCart: !this.state.showCart
        });
    }
    handleSubmit(e) {
        e.preventDefault();
    }
    handleMobileSearch(e) {
        e.preventDefault();
        this.setState({
            mobileSearch: true
        });
    }
    handleSearchNav(e) {
        e.preventDefault();
        this.setState(
            {
                mobileSearch: false
            },
            function () {
                this.refs.searchBox.value = "";
                this.props.handleMobileSearch();
            }
        );
    }
    handleClickOutside(event) {
        const cartNode = findDOMNode(this.refs.cartPreview);
        if (cartNode.classList.contains("active")) {
            if (!cartNode || !cartNode.contains(event.target)) {
                this.setState({
                    showCart: false
                });
                event.stopPropagation();
            }
        }
    }
    componentDidMount() {
        document.addEventListener(
            "click",
            this.handleClickOutside.bind(this),
            true
        );
    }
    componentWillUnmount() {
        document.removeEventListener(
            "click",
            this.handleClickOutside.bind(this),
            true
        );
    }
    
    goCountries = () => this.props.history.push("Countries");

    render() {
        let deleteCountry = () => {
            let body = this.state;
            Axios.delete("http:.//localhost:8081/model/Country" + 
            this.props.name)
            .then( res => {
                console.log("Form is submitted");
                console.log(res);
            }).catch(
                error => {
                    console.log("error");
                }
            )
        }

 return (
    <header>
        <div className="container">
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <a className="navbar-brand" href="#">Exam</a>
                    <button onClick={this.goCountries}
                     className="btn btn-primary"
                     role="button">
                     Countries
                    </button>
                 <button onClick={this.goCountries} className="navbar-toggler"data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>

                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item active">
                                <a className="nav-link" href="#">Home <span className="sr-only">(current)</span></a>
                            </li>
                        </ul>
                     <form className="form-inline my-2 my-lg-0" method="get"
                         className={
                             this.state.mobileSearch ? "search-form active" : "search-form"
                         }>
                         <input className="form-control mr-sm-2" type="search"
                             ref="searchBox" placeholder="Search Countries"
                             onChange={this.props.handleSearch}></input>
                         <button className="btn btn-outline-primary my-2 my-sm-0" className="search-button"
                             type="submit" onClick={this.handleSubmit.bind(this)}>Search</button>
                        </form>
                    </div>
                </nav>
          </div>
    </header>
    );
    }
}
export default Header;

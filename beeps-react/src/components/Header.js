import React, { Component } from "react";
import ScrollBar from "./ScrollBar";
import EmptyCart from "../empty-states/EmptyCart";
import CSSTransitionGroup from "react-transition-group/CSSTransitionGroup";
import { findDOMNode } from "react-dom";

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
    
    goProducts = () => this.props.history.push("products");
// o patį mygtuką kur nors į render() metodą


    render() {
        let cartItems;
        cartItems = this.state.cart.map(product => {
            return (
                <li className="cart-item" key={product.name}>
                    <img className="product-image" src={product.image} alt=""/>
                    <div className="product-info">
                        <p className="product-name">{product.name}</p>
                        <p className="product-price">{product.price}</p>
                    </div>
                    <div className="product-total">
                        <p className="quantity">
                            {product.quantity} {product.quantity > 1 ? "Nos." : "No."}{" "}
                        </p>
                        <p className="amount">{product.quantity * product.price}</p>
                    </div>
                    <a
                        className="product-remove"
                        href="/product.remove"
                        onClick={this.props.removeProduct.bind(this, product.id)}
                    >
                        ×
          </a>
                </li>
            );
        });
        let view;
        if (cartItems.length <= 0) {
            view = <EmptyCart />;
        } else {
            view = (
                <CSSTransitionGroup
                    transitionName="fadeIn"
                    transitionEnterTimeout={500}
                    transitionLeaveTimeout={300}
                    component="ul"
                    className="cart-items"
                >
                    {cartItems}
                </CSSTransitionGroup>
            );
        }
 return (
    <header>
        <div className="container">
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <a className="navbar-brand" href="#">Exam</a>
                    <button onClick={this.goProducts}
                     className="btn btn-primary"
                     role="button">
                     Products
                    </button>
                 <button onClick={this.goProducts} className="navbar-toggler"data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
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
                             ref="searchBox" placeholder="Search EXAM products"
                             onChange={this.props.handleSearch}></input>
                         <button className="btn btn-outline-primary my-2 my-sm-0" className="search-button"
                             type="submit" onClick={this.handleSubmit.bind(this)}>Search</button>
                        </form>
                    </div>
                 <div className="cart">
                     <div className="cart-info">
                         <table>
                             <tbody>
                                 <tr>
                                     <td>No. of items</td>
                                     <td>:</td>
                                     <td>
                                         <strong>{this.props.totalItems}</strong>
                                     </td>
                                 </tr>
                                 <tr>
                                     <td>Sub Total</td>
                                     <td>:</td>
                                     <td>
                                         <strong>{this.props.total}</strong>
                                     </td>
                                 </tr>
                             </tbody>
                         </table>
                     </div>
                     <a
                         className="cart-icon"
                         href="#"
                         onClick={this.handleCart.bind(this)}
                         ref="cartButton"
                     >
                         <img
                             className={this.props.cartBounce ? "tada" : " "}
                             src="https://res.cloudinary.com/sivadass/image/upload/v1493548928/icons/bag.png"
                             alt="Cart"
                         />
                         {this.props.totalItems ? (
                             <span className="cart-count">{this.props.totalItems}</span>
                         ) : (
                                 ""
                             )}
                     </a>
                     <div
                         className={
                             this.state.showCart ? "cart-preview active" : "cart-preview"
                         }
                         ref="cartPreview"
                     >
                         <ScrollBar>{view}</ScrollBar>
                         <div className="action-block">
                             <button
                                 type="button"
                                 className={this.state.cart.length > 0 ? " " : "disabled"}
                             >
                                 PROCEED TO CHECKOUT
                </button>
                         </div>
                     </div>
                 </div>
                </nav>
          </div>
    </header>
    );
    }
}
export default Header;

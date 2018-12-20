import React, { Component } from "react";
import Counter from "../Counter";

class Country extends Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedcountry: {},
            quickViewProdcut: {},
            isAdded: false
        };
    }
    addToHoliday(name,  flagImage, prezident, flagIsUp) {
        this.setState(
            {
                selectedCountry: {
                    name: name,
                    flagImage: flagImage,
                    prezident: prezident,
                    flagIsUp: flagIsUp
                }
            },
            function () {
                this.props.addToHoliday(this.state.selectedCountry);
            }
        );
        this.setState(
            {
                isAdded: true
            },
            function () {
                setTimeout(() => {
                    this.setState({
                        isAdded: false,
                        selectedCountry: {}
                    });
                }, 3500);
            }
        );
    }
    quickView(name,  image, prezident, flagIsUp) {
        this.setState(
            {
                quickViewCountry: {
                    name: name,
                     
                    image: image,
                    prezident: prezident,
                    flagIsUp: flagIsUp
                }
            },
            function () {
                this.props.openModal(this.state.quickViewCountry);
            }
        );
    }
    render() {
        let name = this.props.name;
        let image = this.props.image;
        let prezident = this.props.prezident;
        let flagIsUp = this.props.flagIsUp;
        return (
            <div className="country">
                <div className="country-image">
                    <img
                        src={image}
                        alt={this.props.name}
                        onClick={this.quickView.bind(
                            this,
                            image,
                            name,
                            
                            prezident,
                            flagIsUp
                        )}
                    />
                </div>
                <h4 className="country-name">{this.props.name}</h4>
            </div>)
    }
}     
                    
export default Country;

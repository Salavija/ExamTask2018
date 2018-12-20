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
    addToHoliday(name, info, image, type, flagIsUp) {
        this.setState(
            {
                selectedCountry: {
                    name: name,
                    info: info,
                    image: image,
                    type: type,
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
    quickView(name, info, image, type, flagIsUp) {
        this.setState(
            {
                quickViewCountry: {
                    name: name,
                    info: info,
                    image: image,
                    type: type,
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
        let info = this.props.info;
        let type = this.props.type;
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
                            info,
                            type,
                            flagIsUp
                        )}
                    />
                </div>
                <h4 className="country-name">{this.props.name}</h4>
                <p className="country-info">{this.props.info}</p>
                <Counter
                    countryflagIsUp={flagIsUp}
                    updateflagIsUp={this.props.updateflagIsUp}
                    resetflagIsUp={this.resetflagIsUp}
                />
                <div className="country-action">
                    <button
                        className={!this.state.isAdded ? "" : "added"}
                        type="button"
                        onClick={this.addToHolidays.bind(
                            this,
                            image,
                            name,
                            info,
                            type,
                            flagIsUp
                        )}
                    >
                        {!this.state.isAdded ? "ADD TO HOLIDAY" : "✔ ADDED"}
                    </button>
                </div>
            </div>
        );
    }
}

export default Country;
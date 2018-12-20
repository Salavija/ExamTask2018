import React, { Component } from "react";
import Counter from "../Counter";

class Holiday extends Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedHoliday: {},
            quickViewProdcut: {},
            isAdded: false
        };
    }
    addToHoliday(name, info, image, type, flagIsUp) {
        this.setState(
            {
                selectedHoliday: {
                    name: name,
                    info: info,
                    image: image,
                    type: type,
                    flagIsUp: flagIsUp
                }
            },
            function () {
                this.props.addToHoliday(this.state.selectedHoliday);
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
                        selectedHoliday: {}
                    });
                }, 3500);
            }
        );
    }
    quickView(name, info, image, type, flagIsUp) {
        this.setState(
            {
                quickViewHoliday: {
                    name: name,
                    info: info,
                    image: image,
                    type: type,
                    flagIsUp: flagIsUp
                }
            },
            function () {
                this.props.openModal(this.state.quickViewHoliday);
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
            <div className="Holiday">
                <div className="Holiday-image">
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
                <h4 className="Holiday-name">{this.props.name}</h4>
                <p className="Holiday-info">{this.props.info}</p>
                <Counter
                    HolidayflagIsUp={flagIsUp}
                    updateflagIsUp={this.props.updateflagIsUp}
                    resetflagIsUp={this.resetflagIsUp}
                />
                <div className="Holiday-action">
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

export default Holiday;
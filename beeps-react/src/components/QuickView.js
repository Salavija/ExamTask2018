import React, { Component } from "react";
import { findDOMNode } from "react-dom";

class QuickView extends Component {
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

    handleClickOutside(event) {
        const domNode = findDOMNode(this.refs.modal);
        if (!domNode || !domNode.contains(event.target)) {
            this.props.closeModal();
        }
    }

    handleClose() {
        this.props.closeModal();
    }

    render() {
        return (
            <div
                className={
                    this.props.openModal ? "modal-wrapper active" : "modal-wrapper"
                }
            >
                <div className="modal" ref="modal">
                    <button
                        type="button"
                        className="close"
                        onClick={this.handleClose.bind(this)}
                    >
                        &times;
          </button>
                    <div className="quick-view">
                        <div className="quick-view-image">
                            <img
                                src={this.props.country.image}
                                alt={this.props.country.name}
                            />
                        </div>
                        <div className="quick-view-details">
                            <span className="country-name">{this.props.country.name}</span>
                            <span className="country-price">{this.props.country.price}</span>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default QuickView;

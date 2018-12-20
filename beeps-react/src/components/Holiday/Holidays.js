import React, { Component } from "react";
import Holiday from "./Holiday";
import Loadingholidays from "./loaders/holidays";
import NoResults from "./empty-states/NoResults";
import CSSTransitionGroup from "react-transition-group/CSSTransitionGroup";

class Holidays extends Component {
    render() {
        let holidaysData;
        let term = this.props.searchTerm;

        function searchingFor(term) {
            return function (x) {
                return x.name.toLowerCase().includes(term.toLowerCase()) || !term;
            };
        }
        holidaysData = this.props.holidaysList
            .filter(searchingFor(term))
            .map(Holiday => {
                return (
                    <Holiday
                        key={Holiday.id}
                        name={Holiday.name}
                        image={Holiday.image}
                        info={Holiday.info}
                        addToHoliday={this.props.addToHoliday}
                        openModal={this.props.openModal}
                    />
                );
            });
        let view;
        if (holidaysData.length <= 0 && !term) {
            view = <Loadingholidays />;
        } else if (holidaysData.length <= 0 && term) {
            view = <NoResults />;
        } else {
            view = (
                <CSSTransitionGroup
                    transitionName="fadeIn"
                    transitionEnterTimeout={500}
                    transitionLeaveTimeout={300}
                    component="div"
                    className="holidays"
                >
                    {holidaysData}
                </CSSTransitionGroup>
            );
        }
        return <div className="holidays-wrapper">{view}</div>;
    }
}

export default Holidays;

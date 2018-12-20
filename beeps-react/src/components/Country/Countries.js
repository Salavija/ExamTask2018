import React, { Component } from "react";
import Country from "./Country";
import LoadingCountries from "./loaders/Countries";
import NoResults from "./empty-states/NoResults";
import CSSTransitionGroup from "react-transition-group/CSSTransitionGroup";

class Countries extends Component {
    render() {
        let CountriesData;
        let term = this.props.searchTerm;

        function searchingFor(term) {
            return function (x) {
                return x.name.toLowerCase().includes(term.toLowerCase()) || !term;
            };
        }
        CountriesData = this.props.CountriesList
            .filter(searchingFor(term))
            .map(Country => {
                return (
                    <Country
                        key={Country.id}
                        name={Country.name}
                        image={Country.image}
                        info={Country.info}
                        addToHoliday={this.props.addToHoliday}
                        openModal={this.props.openModal}
                    />
                );
            });
        let view;
        if (CountriesData.length <= 0 && !term) {
            view = <LoadingCountries />;
        } else if (CountriesData.length <= 0 && term) {
            view = <NoResults />;
        } else {
            view = (
                <CSSTransitionGroup
                    transitionName="fadeIn"
                    transitionEnterTimeout={500}
                    transitionLeaveTimeout={300}
                    component="div"
                    className="Countries"
                >
                    {CountriesData}
                </CSSTransitionGroup>
            );
        }
        return <div className="Countries-wrapper">{view}</div>;
    }
}

export default Countries;

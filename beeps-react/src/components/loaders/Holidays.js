import React, { Component } from "react";
import Holiday from "./Holiday/Holiday";


class LoadingHolidays extends Component {
    render() {
        return (
            <div className="Holidays loading">
                <Holiday />
                <Holiday />
                <Holiday />
                <Holiday />
                <Holiday />
                <Holiday />
                <Holiday />
                <Holiday />
            </div>
        );
    }
}

export default LoadingHolidays;
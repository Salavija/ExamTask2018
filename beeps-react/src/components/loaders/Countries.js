import React, { Component } from "react";
import Country from "./Country/Country";

class LoadingCountries extends Component {
  render() {
    return (
      <div className="Countrys loading">
        <Country />
        <Country />
        <Country />
        <Country />
        <Country />
        <Country />
        <Country />
        <Country />
      </div>
    );
  }
}

export default LoadingCountries;

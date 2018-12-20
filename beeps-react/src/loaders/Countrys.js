import React, { Component } from "react";
import Country from "./Country";

class LoadingCountrys extends Component {
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

export default LoadingCountrys;

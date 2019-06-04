import React, { Component } from "react";

import company from "../Model/Company";
import DumbCompany from "./DumbCompany";

const mapModelStateToComponentState = modelState => ({
    companies: modelState.companies

});

export default class SmartCreateUser extends Component{
    constructor()
    {
        super();
        this.state = mapModelStateToComponentState(company.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        company.addListener("change", this.listener);

    }

    componentWillUnmount() {
        company.removeListener("change", this.listener);
    }

    render(){
        return(
            <DumbCompany
                companies={this.state.companies}
            />
        );
    }

}
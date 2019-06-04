import React, { Component } from "react";
import DumbOwnedCompanies from "./DumbOwnedCompanies";
import company from "../Model/Company";

const mapModelStateToComponentState = modelState => ({
    companiesOfCurrentOwner: modelState.companiesOfCurrentOwner

});

export default class SmartTransaction extends Component{
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
            <DumbOwnedCompanies
                companiesOfCurrentOwner={this.state.companiesOfCurrentOwner}
            />
        );
    }

}
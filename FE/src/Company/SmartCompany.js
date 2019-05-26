import React, { Component } from "react";

import companyPresenter from "./CompanyPresenter";
import investor from "../Model/Investor";
import DumbCompany from "./DumbCompany"

const mapModelStateToComponentState = modelState => ({
    currentInvestor: modelState.currentInvestor

});

export default class SmartCreateUser extends Component{
    constructor()
    {
        super();
        this.state = mapModelStateToComponentState(investor.state)
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        investor.addListener("change", this.listener);

    }

    componentWillUnmount() {
        investor.removeListener("change", this.listener);
    }

    render(){
        return(
            <DumbCompany
                onClick={companyPresenter.logout}
            />
        );
    }

}
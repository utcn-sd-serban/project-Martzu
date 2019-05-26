import React, { Component } from "react";

import createInvestorPresenter from "./CreateInvestorPresenter";
import investor from "../Model/Investor";
import DumbCreateInvestor from "./DumbCreateInvestor"

const mapModelStateToComponentState = modelState => ({
    newInvestor: modelState.newInvestor

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
            <DumbCreateInvestor
                onChange={createInvestorPresenter.changeProperties}
                onClick={createInvestorPresenter.onClick}

            />
        );
    }

}
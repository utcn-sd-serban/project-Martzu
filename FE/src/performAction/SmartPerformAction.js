import React, { Component } from "react";
import DumbPerformAction from "./DumbPerformAction";
import company from "../Model/Company";
import performActionPresenter from "./PerformActionPresenter";

const mapModelStateToComponentState = modelState => ({
    companiesOfCurrentOwner: modelState.companiesOfCurrentOwner

});

export default class SmartPerformAction extends Component{
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
            <DumbPerformAction
                onChange={performActionPresenter.onChange}
                onClick={performActionPresenter.onClick}
            />
        );
    }

}
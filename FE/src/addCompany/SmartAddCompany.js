import React, { Component } from "react";
import owner from "../Model/Owner"
import DumbAddCompany from "./DumbAddCompany";
import addCompanyPresenter from "./AddCompanyPresenter";

const mapModelStateToComponentState = modelState => ({
    currentOwner: modelState.currentOwner

});

export default class SmartTransaction extends Component{
    constructor()
    {
        super();
        this.state = mapModelStateToComponentState(owner.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        owner.addListener("change", this.listener);

    }

    componentWillUnmount() {
        owner.removeListener("change", this.listener);
    }

    render(){
        return(
            <DumbAddCompany
                onChange={addCompanyPresenter.onChange}
                onClick={addCompanyPresenter.onClick}
            />
        );
    }

}
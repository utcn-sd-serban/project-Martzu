import React, { Component } from "react";
import investor from "../Model/Investor"
import DumbLogin from "./DumbLogin";
import loginPresenter from "./LoginPresenter";

const mapModelStateToComponentState = modelState => ({
    currentInvestor: modelState.currentInvestor

});

export default class SmartLogin extends Component{
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
            <DumbLogin
                onChange={loginPresenter.changeLoginProperties}
                onClickLogin={loginPresenter.verifyUser}
                onClickCreateUser={loginPresenter.changeCreateAccount}
            />
        );
    }

}
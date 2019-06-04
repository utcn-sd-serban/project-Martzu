import React, { Component } from "react";

import owner from "../Model/Owner";
import DumbCreateOwner from "./DumbCreateOwner";
import createOwnerPresenter from "./CreateOwnerPresenter";


const mapModelStateToComponentState = modelState => ({
    newOwner: modelState.newOwner

});

export default class SmartCreateOwner extends Component{
    constructor()
    {
        super();
        this.state = mapModelStateToComponentState(owner.state)
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        owner.addListener("change", this.listener);

    }

    componentWillUnmount() {
        owner.removeListener("change", this.listener);
    }

    render(){
        return(
            <DumbCreateOwner
                onChange={createOwnerPresenter.changeProperties}
                onClick={createOwnerPresenter.onClick}

            />
        );
    }

}
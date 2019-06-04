import React, { Component } from "react";
import DumbOwnedStocks from "./DumbOwnedStocks";
import ownedStocks from "../Model/OwnedStocks";

const mapModelStateToComponentState = modelState => ({
    ownedStocks: modelState.ownedStocks

});

export default class SmartTransaction extends Component{
    constructor()
    {
        super();
        this.state = mapModelStateToComponentState(ownedStocks.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        ownedStocks.addListener("change", this.listener);

    }

    componentWillUnmount() {
        ownedStocks.removeListener("change", this.listener);
    }

    render(){
        return(
            <DumbOwnedStocks
                ownedStocks={this.state.ownedStocks}
            />
        );
    }

}
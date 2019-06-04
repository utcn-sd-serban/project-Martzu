import React, { Component } from "react";
import transaction from "../Model/Transaction"
import DumbTransactionHistory from "./DumbTransactionHistory";

const mapModelStateToComponentState = modelState => ({
    transactionsOfCurrentUser: modelState.transactionsOfCurrentUser

});

export default class SmartTransaction extends Component{
    constructor()
    {
        super();
        this.state = mapModelStateToComponentState(transaction.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        transaction.addListener("change", this.listener);

    }

    componentWillUnmount() {
        transaction.removeListener("change", this.listener);
    }

    render(){
        return(
            <DumbTransactionHistory
                transactions={this.state.transactionsOfCurrentUser}
            />
        );
    }

}
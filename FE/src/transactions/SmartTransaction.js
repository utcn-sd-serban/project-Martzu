import React, { Component } from "react";
import transaction from "../Model/Transaction"
import DumbTransaction from "./DumbTransaction";
import transactionPresenter from "./TransactionPresenter";

const mapModelStateToComponentState = modelState => ({
    currentInvestor: modelState.currentInvestor

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
            <DumbTransaction
                onChange={transactionPresenter.changeProperties}
                onClickBuy={transactionPresenter.onClickBuy}
                onClickSell={transactionPresenter.onClickSale}
            />
        );
    }

}
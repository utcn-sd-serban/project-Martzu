import React, { Component } from 'react';
import './App.css';

import {HashRouter, Switch, Route} from "react-router-dom";
import SmartLogin from "./Login/SmartLogin";
import SmartCompany from "./Company/SmartCompany";
import SmartCreateInvestor from "./CreateInvestor/SmartCreateInvestor";
import SmartCreateOwner from "./createOwner/SmartCreateOwner";
import SmartTransaction from "./transactions/SmartTransaction";
import SmartOwnedStocks from "./ownedStocks/SmartOwnedStocks";
import SmartTransactionHistory from "./transactionHistory/SmartTransactionHistory";
import SmartCompanyOwner from "./CompanyOwner/SmartCompanyOwner";
import SmartOwnedCompanies from "./OwnedCompanies/SmartOwnedCompanies";
import SmartAddCompany from "./addCompany/SmartAddCompany";
import SmartPerformAction from "./performAction/SmartPerformAction";

class App extends Component{
  render()
  {
    return (
        <div className="App">
          <HashRouter>
            <Switch>
                <Route exact={true} component={SmartLogin} path = "/"/>
                <Route exact={true} component={SmartCompany} path = "/company"/>
                <Route exact={true} component={SmartCreateInvestor} path = "/create-investor"/>
                <Route exact={true} component={SmartCreateOwner} path = "/create-owner"/>
                <Route exact={true} component={SmartTransaction} path = "/place-transaction"/>
                <Route exact={true} component={SmartOwnedStocks} path = "/owned-stocks"/>
                <Route exact={true} component={SmartTransactionHistory} path = "/transactions"/>
                <Route exact={true} component={SmartCompanyOwner} path = "/company-owner"/>
                <Route exact={true} component={SmartOwnedCompanies} path = "/owned-companies"/>
                <Route exact={true} component={SmartAddCompany} path = "/add-company"/>
                <Route exact={true} component={SmartPerformAction} path = "/perform-action"/>


            </Switch>
          </HashRouter>
        </div>

    );
  }
}

export default App;

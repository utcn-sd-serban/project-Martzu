import React, { Component } from 'react';
import './App.css';

import {HashRouter, Switch, Route} from "react-router-dom"
import SmartLogin from "./Login/SmartLogin";
import SmartCompany from "./Company/SmartCompany"
import SmartCreateInvestor from "./CreateInvestor/SmartCreateInvestor"


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
            </Switch>
          </HashRouter>
        </div>

    );
  }
}

export default App;

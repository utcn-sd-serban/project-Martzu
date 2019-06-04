import React from 'react';

const DumbTransaction = ({onChange, onClickBuy, onClickSell}) => (

    <div>

        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <a className="navbar-brand" href="#/company">SPET Stock exchange</a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
                <ul className="navbar-nav">
                    <li className="nav-item active">
                        <a className="nav-link" href="#/transactions">View transactions <span className="sr-only">(current)</span></a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#/owned-stocks" >View owned stocks</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#/">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        <label>
            Company:
        </label>
        <input
            onChange={e => onChange("company", e.target.value)}/>

        <label>
            Stock number:
        </label>
        <input
            onChange={e => onChange("stockNumber", e.target.value)}/>


        <button
            onClick={onClickBuy}> Buy
        </button>

        <button
            onClick={onClickSell}> Sell
        </button>


    </div>







);
export default DumbTransaction;
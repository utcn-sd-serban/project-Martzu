import React from 'react';

const DumbTransactionHistory = ({transactions}) => (

    <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <a className="navbar-brand" href="#/company">SPET Stock exchange</a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
                <ul className="navbar-nav">
                    <li className="nav-item">
                        <a className="nav-link" href="#/owned-stocks" >View owned stocks</a>
                    </li>

                    <li className="nav-item">
                        <a className="nav-link" href="#/place-transaction">Place a transaction</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#/">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        {
            transactions.map((transaction, index) => (

                <div className="jumbotron">
                    <h1 className="display-4">{transaction.company}</h1>
                    <p className="lead">Share number: {transaction.stockNumber}</p>
                    <hr className="my-4"/>
                    <p>Share price: {transaction.stockPrice}</p>
                    <p>Transaction type: {transaction.type}</p>
                    <p>Date: {transaction.date}</p>
                </div>
                )
            )
        }

    </div>







);
export default DumbTransactionHistory;
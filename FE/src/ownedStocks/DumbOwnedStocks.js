import React from 'react';

const DumbOwnedStocks = ({ownedStocks}) => (

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
                        <a className="nav-link" href="#/place-transaction">Place a transaction</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#/">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        {
            ownedStocks.map((ownedStock, index) => (


                    <div className="jumbotron">
                        <h1 className="display-4">{ownedStock.company}</h1>
                        <p className="lead">Share number: {ownedStock.shareNumber}</p>
                        <hr className="my-4"/>
                            <p>Share price: {ownedStock.sharePrice}</p>
                    </div>



                )


            )

        }


    </div>







);
export default DumbOwnedStocks;
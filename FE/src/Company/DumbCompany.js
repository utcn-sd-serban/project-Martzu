import React from 'react';

const DumbCompany = ({companies}) => (

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
                        <a className="nav-link" href="#/place-transaction">Place a transaction</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#/">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        {
            companies.map((company, index) => (


                    <div className="jumbotron">
                        <h1 className="display-4">{company.name}</h1>
                        <p className="lead">{company.tag}</p>
                        <p className="lead">Share number: {company.shares}</p>
                        <hr className="my-4"/>
                        <p>Share price: {company.sharePrice}</p>
                    </div>
                )


            )
        }


    </div>


);
export default DumbCompany;
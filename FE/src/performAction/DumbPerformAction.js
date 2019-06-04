import React from 'react';

const DumbPerformAction = ({onChange, onClick}) => (

    <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <a className="navbar-brand" href="#/company-owner">SPET Stock exchange</a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
                <ul className="navbar-nav">
                    <li className="nav-item active">
                        <a className="nav-link" href="#/owned-companies">View owned companies <span className="sr-only">(current)</span></a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#/add-company" >Create a new company</a>
                    </li>

                    <li className="nav-item">
                        <a className="nav-link" href="#/">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <label>Enter the desired split</label>
        <input
            onChange={e => onChange("split", e.target.value)}/>

        <label> Name of the company: </label>
        <input
            onChange={e => onChange("companyToSplit", e.target.value)}/>

        <button onClick={onClick}> Perform split </button>



    </div>







);
export default DumbPerformAction;
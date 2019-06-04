import React from 'react';

const DumbAddCompany = ({onChange, onClick}) => (

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
                        <a className="nav-link" href="#/perform-action">Perform an action</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#/">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        <label>
            Company name:
        </label>
        <input
            onChange={e => onChange("name", e.target.value)}/>

        <label>
            Tag:
        </label>
        <input
            onChange={e => onChange("tag", e.target.value)}/>

        <label>
            Shares:
        </label>
        <input
            onChange={e => onChange("sharePrice", e.target.value)}/>

        <label>
            Evaluation:
        </label>
        <input
            onChange={e => onChange("evaluation", e.target.value)}/>


        <button
            onClick={onClick}> Add
        </button>


    </div>







);
export default DumbAddCompany;
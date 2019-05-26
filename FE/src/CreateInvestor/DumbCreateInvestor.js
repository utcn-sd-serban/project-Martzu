import React from 'react';

const DumbCreateInvestor = ({onChange, onClick}) => (

    <div>
        <label>
            User Name:
        </label>
        <input
            onChange={e => onChange("username", e.target.value)}/>

        <label>
            Password:
        </label>
        <input
            onChange={e => onChange("password", e.target.value)}/>


        <button
            onClick={onClick}> Create
        </button>

    </div>







);
export default DumbCreateInvestor;
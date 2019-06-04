import React from 'react';

const DumbCreateOwner = ({onChange, onClick}) => (

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
            onClick={onClick}> Create Owner
        </button>


    </div>







);
export default DumbCreateOwner;
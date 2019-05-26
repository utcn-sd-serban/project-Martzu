import React from 'react';

const DumbLogin = ({onChange, onClickLogin, onClickCreateUser}) => (

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
            onClick={onClickLogin}> Login
        </button>

        <button
            onClick={onClickCreateUser}> Create Account

        </button>


    </div>


);
export default DumbLogin;
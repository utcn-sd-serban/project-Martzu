import React from 'react';

const DumbLogin = ({onChange, onClickLogin, onClickLoginOwner, onClickCreateUser, onClickCreateOwner}) => (

    <div>

            <label>
                    User Name:
            </label>
            <input
                onChange={e => onChange("username", e.target.value)}/>


            <label>
                    Password:
            </label>

            <input type="password"
                   onChange={e => onChange("password", e.target.value)}/>



            <button
                onClick={onClickLogin}> Login Investor
            </button>

            <button
                onClick={onClickLoginOwner}> Login Owner
            </button>

            <button
                onClick={onClickCreateUser}> Create Investor
            </button>

            <button
                onClick={onClickCreateOwner}> Create Owner
            </button>

    </div>


);
export default DumbLogin;
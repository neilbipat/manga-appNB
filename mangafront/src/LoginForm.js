import React from 'react';

// custom componeents
import styled from 'styled-components';

// Styling Signup
const Login = styled.form`
    display: flex;
    flex-direction: column;
    margin-bottom: 1%;
`;


const LoginForm = props => {
    return (
        <div className = "Login Form"> 
        <Login onSubmit={props.loginForm}>
            <label htmlFor="username">Username:
            <input
                type="text"
                placeholder="username"
                value={props.usernameLog}
                onChange={props.handleNameLogChange}
            />
            </label>

            <label htmlFor="password">Password:
            <input
                type="text"
                placeholder="password"
                label="password"
                value={props.passwordLog}
                onChange={props.handlePasswordLogChange}
            />
            </label>
            <input type="submit" value="resume"/>

            </Login>
        </div>
    )
}

export default LoginForm;
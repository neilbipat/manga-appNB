import React from 'react';

// custom componeents
import styled from 'styled-components';

// Styling Signup
const Login = styled.form`
    display: flex;
    flex-direction: column;
    margin-bottom: 1%;
`;

// Styling the signupButton
const Button = styled.input`
    width: 10%;
    margin-left: 19%;
    /* This is for cenering the button */
    /* margin: 0 auto; */
`;

// Styling Password
const Password = styled.label`
    margin-left: 0.5%;
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

            <Password htmlFor="password">Password:
            <input
                type="text"
                placeholder="password"
                label="password"
                value={props.passwordLog}
                onChange={props.handlePasswordLogChange}
            />
            </Password>
            <Button type="submit" value="resume"/>

            </Login>
        </div>
    )
}

export default LoginForm;
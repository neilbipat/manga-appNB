import React from 'react';

const LoginForm = props => {
    return (
        <div className = "Login Form"> 
        <form onSubmit={props.loginForm}>
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

            </form>
        </div>
    )
}

export default LoginForm;
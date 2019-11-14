import React from 'react';

// custom components
import styled from 'styled-components';

// Styling Signup
const Signup = styled.form`
    display: flex;
    flex-direction: column;
    margin-bottom: 1%;
`;

// Styling Email
const Email = styled.label`
    margin-left: 16%;
`;

// Styling Password
const Password = styled.label`
    margin-left: 0.5%;
`;

// Styling the signupButton
const Button = styled.input`
    width: 30%;
    margin-left: 68%;

    &: hover {
        color: white; 
        background-color: grey;
    }
    /* This is for cenering the button */
    /* margin: 0 auto; */
`;



const SignupForm = props => {
    return(

        <div>
           <Signup onSubmit={props.submitForm}>

            <label htmlFor="username">Username:
            <input
                type="text"
                placeholder="username"
                label="username"
                value={props.username}
                onChange={props.handleNameChange}
            />
            </label>

            <Email htmlFor="email"> Email:
            <input
                type="text"
                placeholder="email"
                label="email"
                value={props.email}
                onChange={props.handleEmailChange}
            />
            </Email>

            <Password htmlFor="password"> Password:
            <input
                type="text"
                placeholder="password"
                label="password"
                value={props.password}
                onChange={props.handlePasswordChange}
            />
            </Password>
            <Button type="submit" value="create"/>
        </Signup> 
        </div>
    )
}

export default SignupForm;
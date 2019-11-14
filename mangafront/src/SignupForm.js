import React from 'react';

// custom components
import styled from 'styled-components';

const Signup = styled.div`
    text-align: center;
`;



const SignupForm = props => {
    return(

        <Signup>
           <form onSubmit={props.submitForm}>

            <label htmlFor="username">Username:
            <input
                type="text"
                placeholder="username"
                label="username"
                value={props.username}
                onChange={props.handleNameChange}
            />
            </label>

            <label htmlFor="email"> Email:
            <input
                type="text"
                placeholder="email"
                label="email"
                value={props.email}
                onChange={props.handleEmailChange}
            />
            </label>

            <label htmlFor="password"> Password:
            <input
                type="text"
                placeholder="password"
                label="password"
                value={props.password}
                onChange={props.handlePasswordChange}
            />
            </label>
            <input type="submit" value="create"/>
        </form> 
        </Signup>
    )
}

export default SignupForm;
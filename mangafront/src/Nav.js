import React from 'react';

function Nav(props){
    return (
        <div>
            <form className="signupForm Nav" method="post">
                <div className="userNameDiv inputForm">
                    <input type="text" className="userName signupName signUpTexts"
                        placeholder="username" />
                </div>
                <div className="emailDiv inputForm">
                    <input type="text" className="email signUpEmail signUpTexts"
                        placeholder="email" />
                </div>
                <div className="passwordDiv inputForm">
                    <input type="text" className="password signUpPassword signUpTexts"
                        placeholder="password" />
                </div>
                <button type="submit" className="button signUpButton" >Sign In</button>
            </form>

            <form className="logInForm Nav" method='post'>
                <div className="userNameDiv inputForm">
                    <input type="text" className="userName logInName logInTexts"
                        placeholder="username" />
                </div>
                <div className="passwordDiv inputForm">
                    <input type="text" className="password logInPassword logInTexts"
                        placeholder="password" />
                </div>
                <button type="submit" className="button signUpButton">Log In</button>
            </form>
        </div>
    )
}

export default Nav;
import React, {Component} from 'react';
import './App.css';

// custom components
import Shounen from './Shounen';
import styled from 'styled-components';
import SignupForm from './SignupForm';
import LoginForm from './LoginForm';
import UserList from './UserList';

// SignAndLogInDiv
const SignAndLogInDiv =styled.div`
  /* Hover the button */

  display:flex;
  justify-content: space-around;
  margin-top: 1%;
`;


// Logout Button
const LogOutButton = styled.button`
  width: 8%;
  height: 5%;
  border-radius: 5px;

  /* Hover */
  &: hover {
    color: white;
    background-color: grey;
  }
  
`;

// BodyDiv

const BodyDiv = styled.div`
  display: flex;
  justify-content: center;
  justify-content: space-around;
`;





class App extends Component{

  constructor(props) {
    super(props);

    this.state = {
      apiLoaded: false,
      username: "",
      email: "",
      password: "",
      token: "",
      usernameLog: "",
      passwordLog: "",

    }
  }

  //==== Signup Form ===//


  submitSignupForm = (e) => {
    e.preventDefault();
    fetch("http://localhost:8081/signup", {
      method: 'POST',
      headers: {
        'Accept': 'application/json, text/plain , */*',
        'Content-Type' : 'application/json'
      },
      body: JSON.stringify({
        username: this.state.username,
        email: this.state.email,
        password: this.state.password
      })
    })
      .then(res => res.json())
      .then(res => {
        console.log(res, "I got a response!")
        this.setState({
          username: "",
          email: "",
          password: "",
          token: res.token,
          apiLoaded: true
        })
        if(this.state.token == null){
          alert(`Please Sign in`);
        }
      })
      .catch(error => {
        console.log(error);
      })
  }

  //===Login Form===//
  
  submitLoginForm = (e) => {
    e.preventDefault();
    fetch("http://localhost:8081/login", {
      method: 'POST',
      headers: {
        'Accept' : 'application/json, text/plain, */*',
        'Content-Type' : 'application/json'
      },
      body: JSON.stringify({
        username: this.state.usernameLog,
        password: this.state.passwordLog
      })
    })
      .then(res => res.json())
      .then(res => {
        console.log(res, "I got a response")
        this.setState({
          usernameLog: "",
          passwordLog: "",
          token: res.token,
          apiLoaded: true
        })
        if (this.state.token == null) {
          alert(`Please Sign in`);
        }
      })
      .catch(error => {
        console.log(error);
      })
  }

  //===The 3 are for signup===//

  handleNameChange = (e) => {
    this.setState({ username: e.target.value})
  }

  handleEmailChange = (e) => {
    this.setState({email: e.target.value})
  }

  handlePasswordChange = (e) => {
    this.setState({password: e.target.value})
  }

  //===The two are for login===//

  handleNameLogChange = (e) => {
    this.setState({usernameLog: e.target.value})
  }

  handlePasswordLogChange = (e) => {
    this.setState({passwordLog: e.target.value})
  }

  //Logout function===//
  logOut = () => {
    window.location.reload();
  }


  render(){
    return (
      <div className="App">
        <SignAndLogInDiv>
        {this.state.apiLoaded}
        <SignupForm
        username ={this.state.username}
        email ={this.state.email}
        password={this.state.password}
        handleNameChange={this.handleNameChange}
        handleEmailChange={this.handleEmailChange}
        handlePasswordChange={this.handlePasswordChange}
        submitForm={this.submitSignupForm}/>

        <LoginForm
        usernameLog={this.state.usernameLog}
        passwordLog={this.state.passwordLog}
        handleNameLogChange={this.handleNameLogChange}
        handlePasswordLogChange={this.handlePasswordLogChange}
        loginForm={(e) => this.submitLoginForm(e)} />

        <LogOutButton onClick={this.logOut}>Log out</LogOutButton>
        </SignAndLogInDiv>

        <BodyDiv>
        <Shounen
          token = {this.state.token}
        />
        <UserList
          token = {this.state.token}
        />
        </BodyDiv>      
      </div>
       
    );
  }
}

export default App;


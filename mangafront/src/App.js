import React, {Component} from 'react';
import './App.css';
import {
  BrowserRouter as Router,
  Link,
  Switch,
  Route
} from "react-router-dom";

// custom components
import Shounen from './Shounen';
import styled from 'styled-components';
import CreateForm from './CreateForm';

const Nav = styled.nav`
width: 100%;
display: flex;
justify-content: center;
height: 100px;
align-items: center;
`;

const Links = styled(Link)`
width: 100%;
display: flex;
justify-content: center;
height: 100px;
align-items: center;
`;

class App extends Component{

  constructor(props) {
    super(props);

    this.state = {
      apiLoaded: false,
      username: "",
      email: "",
      password: "",
      token: ""
    }
  }

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
      })
      .catch(error => {
        console.log(error);
      })
  }

  handleNameChange = (e) => {
    this.setState({ username: e.target.value})
  }

  handleEmailChange = (e) => {
    this.setState({email: e.target.value})
  }

  handlePasswordChange = (e) => {
    this.setState({password: e.target.value})
  }

  


  render(){
    return (
      <Router>
      <div className="App">
        {this.state.apiLoaded}
        )
      }
        <CreateForm
        username ={this.state.username}
        email ={this.state.email}
        password={this.state.password}
        handleNameChange={this.handleNameChange}
        handleEmailChange={this.handleEmailChange}
        handlePasswordChange={this.handlePasswordChange}
        submitForm={this.submitSignupForm}/>
          
        <Nav>
          <Links to="shounen">Shounen</Links>
         
        </Nav>
        <Switch>
          <Route
          path="/shounen" 
          component = {Shounen}/>
            
         
        </Switch>
          
      </div>
        </Router>
    );
  }
}

export default App;

//  <Navbar></Navbar>
// <Manga></Manga>
// <Footer></Footer>
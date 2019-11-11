import React, {Component} from 'react';
import './App.css';
import {
  BrowserRouter as Router,
  Link,
  Switch,
  Route
} from "react-router-dom";

// custom components
import LogIn from './LogIn';
import Shounen from './Shounen';
import styled from 'styled-components';

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

  constructor() {
    super();
    this.state = {
      apiLoaded: false
    }
  }

  useInput = () => {
    fetch(`https://www.mangaeden.com/api/manga/4e70ea03c092255ef7004712/`)
      .then((res) => {
        return res.json();
      })
      .then((res) => {
        console.log(res);
        this.setState({
          alias: res.alias,
          description: res.description,
          apiLoaded: true
        })
      })
      .catch((error) => {
        console.log(error);
      })
  };

  renderManga = () => {
    return <div><p>{this.state.alias}</p>
    <p>{this.state.description}</p></div>
  }

  render(){
    return (
      <Router>
      <div className="App">
          <LogIn></LogIn>
        <Nav>
          <Links to="shounen">Shounen</Links>
         
        </Nav>
        <Switch>
          <Route
          path="/shounen" 
          component = {Shounen}/>
            
         
        </Switch>
        <div className = "JumpMangas">
          <button onClick = {this.useInput}>Manga</button>
          <div>
          {this.state.apiLoaded ? this.renderManga(): "Your manga is loading"}
          </div>
        </div>
      </div>
        </Router>
    );
  }
}

export default App;

//  <Navbar></Navbar>
// <Manga></Manga>
// <Footer></Footer>
import React, {Component} from 'react';
import './App.css';
import {
  BrowserRouter as Router,
  Link,
  Switch,
  Route
} from "react-router-dom";

// custom components
import Nav from './Nav';
import Shounen from './Shounen';

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
        <Nav>
          <Link to="shounen">Shounen</Link>
        </Nav>
        <Switch>
          <Route
          path="/shounen" 
          componenet = {Shounen}/>
            
         
        </Switch>
        <div className = "JumpMangas">
          <button onClick ={this.useInput}>Manga</button>
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
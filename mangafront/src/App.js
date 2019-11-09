import React, {Component} from 'react';
import './App.css';

// custom components
import Nav from './Nav';

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
      <div className="App">
        <Nav></Nav>
        <div className = "JumpMangas">
          <button onClick ={this.useInput}>Manga</button>
          <div>
          {this.state.apiLoaded ? this.renderManga(): "Your manga is loading"}
          </div>
        </div>
      </div>
    );
  }
}

export default App;

//  <Navbar></Navbar>
// <Manga></Manga>
// <Footer></Footer>
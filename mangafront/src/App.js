import React, {Component} from 'react';
import './App.css';

class App extends Component{

  constructor(){
    super();
    this.state = {
      apiLoaded: false
    }
  }
  useInput = () => {
    fetch(`https://www.mangaeden.com/api/list/0/`)
      .then((res) => {
        return res.json();
      })
      .then((res) => {
        // console.log(res);
        this.setState({
          manga: res.manga[0].a, 
          apiLoaded: true
        })  
      })
      .catch((error) => {
        console.log(error);
      })
  };

  renderManga = ()  => {
    return <p>{this.state.manga}</p>
  }

  render(){


    return (
      <div className="App">
        <input type="text" placeholder="search" />
        <button onClick={this.useInput}>Hey</button>
        <div>
          {this.state.apiLoaded ? this.renderManga(): "Your manga is loading"}
        </div>
      </div>
    );

  }
 
}

export default App;

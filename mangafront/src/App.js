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
    fetch(`https://www.mangaeden.com/api/chapter/5c56996c719a1689f3231217`)
      .then((res) => {
        return res.json();
      })
      .then((res) => {
        console.log(res);
        this.setState({
          images: res.images[0]["d7/d72b5fb2022bb68e37065f9d2c2f003ec455a918c3d4d1cc209e7701.png"], 
          apiLoaded: true
        })  
      })
      .catch((error) => {
        console.log(error);
      })
  };

  renderManga = ()  => {
    return <p>{this.state.images}</p>
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

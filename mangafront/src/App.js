import React, {Component} from 'react';
import './App.css';



class App extends Component{

  render(){
    return (
      <div className="App">
        <form className="signupForm" method="post">
          <div className="userNameDiv inputForm">
            <input type = "text" className="userName signupName signupTexts"
            placeholder="username"/>
          </div>
          <div className="emailDiv inputForm">
            <input type ="text" className="email signupTexts"
            placeholder="email"/>
          </div>
          <div className="passwordDiv inputForm">
            <input type="text" className="password signupTexts"
            placeholder="password"/>
          </div>
        </form>
      
      </div>
    );
  }
}

export default App;

//  <Navbar></Navbar>
// <Manga></Manga>
// <Footer></Footer>
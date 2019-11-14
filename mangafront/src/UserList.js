import React, {Component}from 'react';

class UserList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            apiDataLoaded: false,
            apiDataError: false,
            title: []
        }
    }

   showUserList =(e) => {
       e.preventDefault();
            console.log(this.props.token, "using token in shounen");
            fetch(`http://localhost:8081/get/listUserMangas/`, {
                method: 'GET',
                headers: {
                    'Accept': 'application/json, text/plain, */*',
                    'Content-Type': 'application/json',
                    "Authorization": "Bearer " + this.props.token
                }
            })
            .then(res => {
              return  res.json();
            })
            .then((res) => {
                this.setState({
                    title: res
                })

                

                    console.log(this.state.title, "User's mangas is shown!")
                })
       
            .catch(err => {
                console.log(err);
                this.setState({apiDataError: true})
            })   
    }


    
    render() {
        return (
            <div>
                <h1>Your List</h1>
                <button onClick={this.showUserList}></button>
                {this.state.title.map((manga, key) => {
                    return <p key={key}>{manga.title}</p>
                })}
            </div>
        )
    }


}

export default UserList;
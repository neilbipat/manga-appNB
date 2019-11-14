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

        deleteFromUserList =(mangaTitle) => {
           
            fetch(`http://localhost:8081/delete/${mangaTitle}/`, {
                method: 'DELETE',
                headers: {
                    'Accept': 'application/json, tex/plain, */*',
                    'Content-Type' : 'application/json',
                    "Authorization": "Bearer " + this.props.token
                }
            })
                .then(res => res.json())
                .then(res => {
                    let updateList = this.state.title;
                    let index = this.state.title.indexOf(updateList);
                    console.log(index)
                    updateList.splice(index, 1);
                    console.log(updateList);
                    this.setState({
                        title: updateList
                    })
                    console.log(res, "I got a response")
                })
        }

    
    render() {
        return (
            <div>
                <h1>Your List</h1>
                <button onClick={this.showUserList}></button>
                {this.state.title.map((manga, key) => {
                    return <div key={key}>
                    <p>{manga.title}</p>
                        <a target="_blank" href={`https://www.mangaeden.com/en/en-manga/${manga.title}/`}>View manga here</a>
                    <button onClick={() => this.deleteFromUserList(manga.title)}></button>
                    </div>
                    
                })}
            </div>
        )
    }


}

export default UserList;
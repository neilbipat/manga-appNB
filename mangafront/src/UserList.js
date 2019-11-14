import React, {Component}from 'react';

// custom componenets
import styled from 'styled-components';
    
// const ReadingList
    const ReadingList = styled.div`
        display: flex;
        align-items: center;
        flex-direction: column;
    `;

    //YourList
    const YourList = styled.h1`
    text-align: center;
        
    `

// const ShowList
    const ShowList = styled.button`
        width: 5vw;
        margin-bottom: 2%;
        font-family: 'McLaren', cursive;

        &: hover {
            color: white;
            background-color: grey;
        }

    `;

// const Delete
    const Delete = styled.button `
        width: 40%;
        margin-left: 30%;
        margin-top: 4%;
        font-family: 'McLaren', cursive;

        &: hover {
            color: white-space;
            background-color: grey;
        }
    `;

    // Title

    const Title = styled.p`
        text-align: center;

        /* margin-right: 20%; */
    `;

// Hyperlink
    const Hyperlink = styled.a`
        text-decoration: none;
        text-align: center;
        margin-left: 30%;
        margin-bottom: 6%;

        color: black;
        

        &: hover {
            color: blue;
            cursor: pointer;
        }
    `;

// Card
    const Card = styled.div`
        border: 1px solid black;
        border-radius: 10px;
        margin-bottom: 3%;
        width: 30vw;
        max-width: 70%;
        height: 1%;
        background-color: pink;
    `;

class UserList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            apiDataLoaded: false,
            apiDataError: false,
            title: []
        }
    }

    //========Shows the user list ========//

   showUserList =(e) => {
       e.preventDefault();
       if (this.props.token === "" || this.props.token === undefined){
           alert(`Please Sign in`)
       } else{

       
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
    }

    //==========deleteFromUserList===========//

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

        //===========render==========// 

    
    render() {
        return (
            <ReadingList>
                <YourList>Your List</YourList>
                <ShowList onClick={this.showUserList}>Your List</ShowList>
                {this.state.title.map((manga, key) => {
                    return <Card key={key}>
                        <Title>{manga.title}</Title>
                        <Hyperlink target="_blank" href={`https://www.mangaeden.com/en/en-manga/${manga.title}/`}>View manga here</Hyperlink>
                        <Delete onClick={() => this.deleteFromUserList(manga.title)}>Delete</Delete>
                    </Card>
                    
                })}
            </ReadingList>
        )
    }


}

export default UserList;
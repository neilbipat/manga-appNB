import React, {Component}from 'react';

// custom componenets
import styled from 'styled-components';

// ApiList
const ApiList = styled.div`
    display: flex;
    flex-direction: column;
    border: 1px solid black;
    border-radius: 10px;
    margin-bottom: 3%;
    width: 50%;
    height: 2%;
    background-color: lightblue;
`;

// MangaTitle
const MangaTitle =styled.p`
    text-align: center;
    margin-top: 22%;
`;

// Hyperlink
const Hyperlink = styled.a`
    text-align: center;
    text-decoration: none;

    color: black;

    /* Hover */
    &: hover {
        color: blue;
        cursor: pointer;
    }

`;

// Button
const Button =styled.button`
    width: 40%;
    margin-top: 5%;
    margin-left: 28%;
   

    /* Hover */
    &: hover {
        color: white;
    background-color: grey;
    }

`;

// BigShounen
const BigShounen = styled.h1`
    margin-left: 12%;
`;




class Shounen extends Component {
    constructor(props) {
        super(props);

        this.state = {
            apiDataLoaded: false,
            apiDataError: false,
            shounenArr: [],
            title: ""
        }
    }


    /**
     * componentDidMount is doing 2 things
     * 1. getting the manga from the mangaList
     * 2. taking this manga and posting to the backend 
     */

    componentDidMount() {
        let shounenArr = this.state.shounenArr;
        console.log(shounenArr);
        fetch('https://www.mangaeden.com/api/list/0/')
            .then((res) => {
                return res.json();
            })
            .then((res) => {
                res.manga.slice(0, 300).map(element => {
                    let query = 'Shounen'
                    // let genreCheck =  element.c.filter(genre => genre.indexOf(query.toLowerCase()) !== -1)
                    for (let i = 0; i < element.c.length; i++) {
                        if (element.c[i] === query) {
                            shounenArr.push(element);
                        }
                    }

                    // this is the way we return in jsx setting the array to the state
                    this.setState({
                        shounenArr
                    })
                })
                console.log(shounenArr)
            })
            .then(res => {
                this.setState({
                    apiDataLoaded: true,
                    data: res
                })
                // shounenArr.map(shounenManga => {
                //     fetch(`http://localhost:8081/manga/add`, {
                //         method: 'POST',
                //         headers: {
                //             'Accept': 'application/json, text/plain, */*',
                //             'Content-Type': 'application/json'
                //         },
                //         body: JSON.stringify({
                //             title: shounenManga.a
                //         })
                //     })
                //         .then(res => {
                //             return res.json()
                //         })
                //         .then(res => {
                //             console.log(res)
                //         })
                //         .catch(error => {
                //             console.log(error);
                //         })
                // })
            })
            .catch(err => {
                console.log(err);
                this.setState({ apiDataError: true })
            })


    }

    //==========add to users ==========//

    addToUserList =(mangaTitle) => {
        console.log("TOKEN", this.props.token)
        if (this.props.token === "" || this.props.token === undefined) {

            alert(`Please Sign in`)
        } else {

        console.log(this.props.token, "using token in shounen");
        fetch(`http://localhost:8081/add/${mangaTitle}/`, {
            method: 'POST',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type' : 'application/json',
                "Authorization": "Bearer " + this.props.token  
            }
        })

            .then(res => res.json())
            .then(res => {
                console.log(res, "I got a response!");
                
            })
        

        }
        
    }
    
    //=======renderShounen=========//
    
    renderShounen() {
        return this.state.shounenArr.map((manga, key) => {
            return <ApiList key = {key}>
                <MangaTitle>{manga.a}</MangaTitle>
                <Hyperlink target="_blank" href={`https://www.mangaeden.com/en/en-manga/${manga.a}`}>View manga here</Hyperlink>
                <Button onClick={() => this.addToUserList(manga.a)} className="item">Add to list?</Button>
                </ApiList>
        })
    }

    //===========regular render==========//

    render() {
        return (
        <div>
            <BigShounen>Shounen</BigShounen>
            {this.state.apiDataError ? "Sorry, mangas not ready" : ""}
            {this.state.apiDataLoaded ? this.renderShounen():"Shounen mangas are loading"}
        </div>
        )
    }
}

export default Shounen;
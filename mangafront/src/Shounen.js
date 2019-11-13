import React, {Component}from 'react';

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

    componentDidMount() {
        let shounenArr = this.state.shounenArr;
        console.log(shounenArr);
        fetch('https://www.mangaeden.com/api/list/0/')
            .then((res) => {
                return res.json();
            })
            .then((res) => {
                res.manga.map(element => {
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
                console.log(console.log(shounenArr))
                shounenArr.map(shounenManga => {
                    fetch(`http://localhost:8081/add/manga/add`, {
                        method: 'POST',
                        headers: {
                            'Accept': 'application/json, text/plain, */*',
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({
                            title: shounenManga.t
                        })
                    })
                })
                        .then(res => {
                            console.log(res, "Manga has been added to backend")
                        })
                        .catch(error => {
                            console.log(error);
                        })
            })
            .then(res => {
                this.setState({
                    apiDataLoaded: true,
                    data: res
                })
            })
            .catch(err => {
                console.log(err);
                 this.setState({apiDataError: true})
            })
    }

    // ADD MANGA TO GENERAL LIST
    addToMangaList =() => {

    }

   

    addToUserList =(mangaTitle) => {
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
                console.log(res, "I got a response!")
            })
    }

    renderShounen() {
        return this.state.shounenArr.map((manga, key) => {
            return <div key = {key}>
                <p>{manga.t}</p>
                <button onClick={() => this.addToUserList(manga.t)} className="item">Add to list?</button>
                <a href={`https://www.mangaeden.com/en/en-manga/${manga.a}/`}>View manga here</a>
            </div>
        })
    }
    render() {
        return (
        <div>
            <h1>Shounen</h1>
            {this.state.apiDataError ? "Sorry, mangas not ready" : ""}
            {this.state.apiDataLoaded ? this.renderShounen():"Your shounen mangas are ready"}

        </div>
        )
    }
}

export default Shounen;
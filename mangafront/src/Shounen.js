import React, {Component}from 'react';

class Shounen extends Component {
    constructor(props) {
        super(props);

        this.state = {
            apiDataLoaded: false,
            apiDataError: false,
            shounenArr: []
        }
    }

    componentDidMount() {
        let shounenArr = this.state.shounenArr;
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

    renderShounen() {
        return this.state.shounenArr.map((manga, key) => {
            return <div key = {key}>
                <p>{manga.t}</p>
                <img src={manga.im}></img>
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
import React, {Component}from 'react';

class Shounen extends Component {
    constructor(props) {
        super(props);

        this.state = {
            apiDataLoaded: false,
            apiDataError: false
        }
    }

    


    componentDidMount() {
        let shounenArr = [];
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
                    return shounenArr;
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
        return <div>
            {this.state.manga.a}
        </div>
    }
}

export default Shounen;
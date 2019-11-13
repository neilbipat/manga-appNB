import React, {Component}from 'react';

class UserList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            title: ""
        }
    }

    componentDidMount() {
            console.log(this.props.token, "using token in shounen");
            fetch(`http://localhost:8081/get/listUserMangas/`, {
                method: 'GET',
                headers: {
                    'Accept': 'application/json, text/plain, */*',
                    'Content-Type': 'application/json',
                    "Authorization": "Bearer " + this.props.token
                }
            })
                .then(res => res.json())
                .then(res => {

                    console.log(res, "User's mangas is shown!")
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
            </div>
        )
    }


}

export default UserList;
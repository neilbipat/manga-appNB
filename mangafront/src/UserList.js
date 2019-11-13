import React, {Component}from 'react';

class Profile extends Component {
    constructor(props) {
        super(props);

        this.state = {
            apiDataLoaded: false,
            apiDataError: false,
            userManga: []
        }
    }

    componentDidMount() {
        let userManga = this.state.userManga;
        fetch('')
    }

}

export default UserList;
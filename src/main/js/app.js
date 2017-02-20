'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
const axios = require('axios');

class Word extends React.Component {
    constructor(props) {
        super(props);
        this.state = {word: ""};
    }

	componentDidMount() {
	    axios({
	        url: '/api/words/combined/random/2',
	        method: 'get',
	        responseType: 'json'
	    }).then(response => {
			this.setState({word: response.data.combinedForm});
		}).catch(error => {
		    console.log("Error fetching random word: " + error);
		});
	}

    render() {
        return (
            <h1>{this.state.word}</h1>
        )
    }
}

class Links extends React.Component {
    render() {
        return (
            <a href="/" title="Nytt ord">Nytt ord</a>
        )
    }
}

ReactDOM.render(<Word />, document.getElementById('randomWord'));
ReactDOM.render(<Links />, document.getElementById('links'));

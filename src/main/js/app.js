'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
const client = require('./client');

class Word extends React.Component {
    constructor(props) {
        super(props);
        this.state = {word: ""};
    }

	componentDidMount() {
		client({method: 'GET', path: '/api/words/combined/random/2'}).done(response => {
			this.setState({word: response.entity.combinedForm});
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

'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const axios = require('axios');
import { Router, Route, hashHistory } from 'react-router'

class App extends React.Component {
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
	    return <RandomWord word={this.state.word} />
	}
}

class RandomWord extends React.Component {
    render() {
        return (
            <div id="randomWord">
                <h1>{this.props.word}</h1>
            </div>
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

ReactDOM.render((
    <Router history={hashHistory}>
        <Route path="/" component={App}/>
    </Router>
), document.getElementById('app'));

import React from 'react'
import axios from 'axios'
import { RandomWord, Word } from './Word'
import Links from './Links'

class RandomWordApp extends React.Component {
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

class AllWordsApp extends React.Component {
    constructor(props) {
        super(props);
        this.state = {words: []};
    }

	componentDidMount() {
	    axios({
	        url: '/api/words/all',
	        method: 'get',
	        responseType: 'json'
	    }).then(response => {
			this.setState({words: response.data});
		}).catch(error => {
		    console.log("Error fetching words: " + error);
		});
	}

	render() {
	    var ws = this.state.words.map(word =>
	        <Word key={word.id} word={word} />
	    );
	    return <div id="allWords">
	        <h1>Alle ordene:</h1>
	        <ul>
	            {ws}
	        </ul>
	    </div>
	}
}

class App extends React.Component {
    render() {
        return (
            <main>
            {this.props.children || <RandomWordApp />}

            <nav>
                <Links />
            </nav>
            </main>
        )
    }
}

export { App, RandomWordApp, AllWordsApp }

import React from 'react'
import axios from 'axios'
import { RandomWord, RandomWordPart, Word } from './Word'
import Links from './Links'

class RandomWordApp extends React.Component {
    constructor(props) {
        super(props);
        this.state = {randomWordParts: []};
    }

	componentDidMount() {
	    axios({
	        url: '/api/words/combined/random/2',
	        method: 'get',
	        responseType: 'json'
	    }).then(response => {
	        var parts = response.data.words.map(w =>
	            <RandomWordPart key={w.word.id} fullForm={w.word.fullForm} partialForm={w.partialForm} />
	        );
			this.setState({randomWordParts: parts});
		}).catch(error => {
		    console.log("Error fetching random word: " + error);
		});
	}

	render() {
	    return <RandomWord parts={this.state.randomWordParts} />
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

class RandomWordWithApp extends RandomWordApp {
	componentDidMount() {
	    axios({
	        url: '/api/words/combined/randomWith/1/'.concat(this.props.params.word),
	        method: 'get',
	        responseType: 'json'
	    }).then(response => {
	        var parts = response.data.words.map(w =>
	            <RandomWordPart key={w.word.id} fullForm={w.word.fullForm} partialForm={w.partialForm} />
	        );
			this.setState({randomWordParts: parts});
		}).catch(error => {
		    console.log("Error fetching random word: " + error);
		    window.location = '/';
		});
	}
}

export { App, RandomWordApp, AllWordsApp, RandomWordWithApp }

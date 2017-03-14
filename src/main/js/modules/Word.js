import React from 'react'
import { Link } from 'react-router'
import { WordLink } from './Links'

class RandomWord extends React.Component {
    render() {
        console.log("parts:");
        console.log(this.props.parts);
        var parts = this.props.parts.map(part =>
            <Link key={part.key} to={"/ord/" + part.props.fullForm}>{part.props.partialForm}</Link>
        );
        return (
            <div id="randomWord">
                <h1>
                {parts}
                </h1>
            </div>
        )
    }
}

class Word extends React.Component {
    render() {
        var url = '/ord/'.concat(this.props.word.fullForm);
        return <li><Link to={url}>{this.props.word.fullForm}</Link></li>
    }
}

class RandomWordPart extends React.Component {
    render() {
        var url = '/ord/'.concat(this.props.word.fullForm);
        return <li><Link to={url}>{this.props.word.partialForm}</Link></li>
    }
}

export { Word, RandomWord, RandomWordPart }

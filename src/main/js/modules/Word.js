import React from 'react'
import { Link } from 'react-router'
import { WordLink } from './Links'

class RandomWord extends React.Component {
    render() {
        return (
            <div id="randomWord">
                <ul>
                {this.props.parts}
                </ul>
            </div>
        )
    }
}

class Word extends React.Component {
    render() {
        return <li><Link to={"/ord/" + this.props.word.fullForm}>{this.props.word.fullForm}</Link></li>
    }
}

class RandomWordPart extends React.Component {
    render() {
        return <li><Link to={"/ord/" + this.props.fullForm}>{this.props.partialForm}</Link></li>
    }
}

export { Word, RandomWord, RandomWordPart }

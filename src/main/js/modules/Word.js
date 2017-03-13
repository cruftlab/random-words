import React from 'react'
import { Link } from 'react-router'

class RandomWord extends React.Component {
    render() {
        return (
            <div id="randomWord">
                <h1>{this.props.word}</h1>
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

export { Word, RandomWord }

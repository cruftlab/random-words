import React from 'react'

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
        return <li>{this.props.word.fullForm}</li>
    }
}

export { Word, RandomWord }

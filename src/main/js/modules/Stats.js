import React from 'react'

class WordStatistics extends React.Component {
    render() {
        return (
            <div id="statistics">
                <h1>Statistikk:</h1>
                <table>
                    <tr>
                        <th>Antall ord:</th>
                        <td>{this.props.wordCount}</td>
                    </tr>
                    <tr>
                        <th>Antall mulige kombinasjoner:</th>
                        <td>{this.props.wordCount * (this.props.wordCount - 1)}</td>
                    </tr>
                </table>
            </div>
        )
    }
}

export { WordStatistics }

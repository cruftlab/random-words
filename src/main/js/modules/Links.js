import React from 'react'
import { Link } from 'react-router'

export default React.createClass({
    render() {
        return (
            <ul role="nav">
                <li><Link to="/">Tilfeldig ord</Link></li>
                <li><Link to="/ord">Alle ord</Link></li>
                <li><Link to="/statistikk">Statistikk</Link></li>
            </ul>
        )
    }
})

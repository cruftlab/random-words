import React from 'react'
import { render } from 'react-dom'
import { Router, Route, hashHistory } from 'react-router'
import { App, AllWordsApp, RandomWordWithApp, WordStatisticsApp } from './modules/App'
import Links from './modules/Links'

render((
    <Router history={hashHistory}>
        <Route path="/" component={App}>
            <Route path="/ord" component={AllWordsApp} />
            <Route path="/ord/:word" component={RandomWordWithApp} />
            <Route path="/statistikk" component={WordStatisticsApp} />
        </Route>
    </Router>
), document.getElementById('app'))

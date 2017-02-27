import React from 'react'
import { render } from 'react-dom'
import { Router, Route, hashHistory } from 'react-router'
import { RandomWordApp, AllWordsApp } from './modules/App'

render((
    <Router history={hashHistory}>
        <Route path="/" component={RandomWordApp}/>
        <Route path="/ord" component={AllWordsApp}/>
    </Router>
), document.getElementById('app'));

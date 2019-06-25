/* eslint-disable */
import React from 'react';
import ReactDOM from 'react-dom';
import { Route, Switch, BrowserRouter as Router } from 'react-router-dom';

import App from './App';
import './index.css';
import LoginPage from './views/loginpage/LoginPage';
import HomePage from './views/homepage/HomePage';


ReactDOM.render(
  (
    <Router>
      <App />
      <Switch>
        <Route path={["/touhouairline_Web_exploded/home"]} component={HomePage} />
        <Route path={["/touhouairline_Web_exploded/login"]} component={LoginPage} />
      </Switch>
    </Router>

  ),
  document.getElementById('root')
);

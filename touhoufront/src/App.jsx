/* eslint-disable */
import React from 'react';
import {
  Link,
  Route,
  Switch,
  BrowserRouter as Router
} from 'react-router-dom';
import axios from 'axios';
import {
  AxiosProvider,
  Request,
  Get,
  Delete,
  Head,
  Post,
  Put,
  Patch,
  withAxios
} from 'react-axios';


import logo from './logo.svg';
import { HomePage, LoginPage } from './views';
import './App.css';

const AppClass = React.createElement({
  render() {
    return (
      <div className="AppClass">
        <div>
          <Get url="test" params={{ id: "12345" }}>
            {(error, response, isLoading, onReload) => {
              if (error) {
                return (<div>Something bad happened: {error.message} <button onClick={() => onReload({ params: { reload: true } })}>Retry</button></div>)
              }
              else if (isLoading) {
                return (<div>Loading...</div>)
              }
              else if (response !== null) {
                console.log(response);
                return (<div>done<button onClick={() => onReload({ params: { id: "12345" } })}>Refresh</button></div>)
              }
              return (<div>Default message before request is made.</div>)
            }}
          </Get>
        </div>
      </div>
    );
  }
})

export default class App extends React.Component {
  render() {
    return (
      <div className="App">
        <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
        <ul>
          <li><Link to="/touhouairline_Web_exploded/home">About</Link></li>
          <li><Link to="/touhouairline_Web_exploded/login">Login</Link></li>
        </ul>
      </div>
      </div>
    );
  }
}

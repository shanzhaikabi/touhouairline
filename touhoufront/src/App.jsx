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
import {
  Button, DefaultButton, Label
} from 'office-ui-fabric-react';



import logo from './logo.svg';
import { HomePage, LoginPage } from './views';
import './App.css';

const testProps = (
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

const testIndex = (
  <div className="App">
    {testProps}
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
);

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      userName: "",
      nickName: "",
      loginStatus: false
    };
  }

  render() {
    let TitleButtonStyle = {
      borderWidth: '0px',
      borderRadius: '0px',
      whiteSpace: 'nowrap',
      float: 'left',
      listStyle: 'none'
    }
    let TitleDivStyle={
      height:'40px'
    }
    let NavDivStyle={
      height:'80px'
    }
    let TitleLoginStyle = {
      fontSize: '10px',
      float: 'right',
      listStyle: 'none'
    }
    const loginTitle = this.state.loginStatus
      ? (
        <ul style={TitleLoginStyle}>
          <li>尊敬的{this.state.nickName},欢迎您登录！</li>
        </ul>
      )
      : (
        <ul style={TitleLoginStyle}>
          <li style={TitleLoginStyle}><Link to="/touhouairline_Web_exploded/register"><Label style={TitleLoginStyle}>注册</Label></Link></li>
          <li style={TitleLoginStyle}><Label style={TitleLoginStyle}>|</Label></li>
          <li style={TitleLoginStyle}><Link to="/touhouairline_Web_exploded/login"><Label style={TitleLoginStyle}>登录</Label></Link></li>
        </ul>
      );

    return (
      <div >
        <div style={TitleDivStyle}>
          {loginTitle}
        </div>
        <div style={NavDivStyle}>
          <ul style={TitleButtonStyle}>
            <li style={TitleButtonStyle}>
              <label className="LabelTitle">Tou Hou Airline</label>
            </li>
            <li style={TitleButtonStyle}>
              <Link to="/touhouairline_Web_exploded/">
                <DefaultButton style={TitleButtonStyle} text="返回首页" />
              </Link>
            </li>
            <li style={TitleButtonStyle}>
              <Link to="/touhouairline_Web_exploded/info">
                <DefaultButton style={TitleButtonStyle} text="航班信息" />
              </Link>
            </li>
            <li style={TitleButtonStyle}>
              <Link to="/touhouairline_Web_exploded/aboard">
                <DefaultButton style={TitleButtonStyle} text="在线值机" />
              </Link>
            </li>
            <li style={TitleButtonStyle}>
              <Link to="/touhouairline_Web_exploded/login">
                <DefaultButton style={TitleButtonStyle} text="会员服务" />
              </Link>
            </li>
          </ul>
        </div>
      </div>
    );
  }
}

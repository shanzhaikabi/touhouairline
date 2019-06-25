/* eslint-disable */
import React from 'react';
import {
  Link
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

import LoginPage from './views/loginpage/LoginPage';
import RegisterPage from './views/loginpage/RegisterPage';
import './App.css';

const pageList = {
  register:'register',
  home:'home',
  login: 'login'
}

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      userName: "",
      nickName: "",
      loginStatus: false,
      pageName: pageList.home,
      showLoginPart: false
    };
  }

  getPage() {
    switch(this.state.pageName)
    {
      case pageList.register:
        return (<RegisterPage />);
    }
  }

  changeLoginStatus(val,usr,nic) {
    this.setState({
      loginStatus:val,
      userName:usr,
      nickName:nic
    });
  }

  gotoLogin() {
    this.setState({
      showLoginPart:true,
      pageName: pageList.login
    });
  }

  hideLogin() {
    this.setState({
      showLoginPart: false
    })
  }

  checkout() {
    this.setState({
      userName: "",
      nickName: "",
      loginStatus: false,
      showLoginPart: false
    })
  }

  render() {
    let TitleButtonStyle = {
      borderWidth: '0px',
      borderRadius: '0px',
      whiteSpace: 'nowrap',
      float: 'left',
      listStyle: 'none'
    }
    let TitleDivStyle = {
      height: '40px'
    }
    let NavDivStyle = {
      height: '80px'
    }
    let TitleLoginStyle = {
      fontSize: '10px',
      float: 'right',
      listStyle: 'none'
    }

    const loginTitle = this.state.loginStatus
      ? (
        <ul style={TitleLoginStyle}>
          <li style={TitleLoginStyle}>尊敬的{this.state.nickName},欢迎您登录！</li>
          <li style={TitleLoginStyle}><Label style={TitleLoginStyle}>|</Label></li>
          <li style={TitleLoginStyle}><Label style={TitleLoginStyle} onClick={()=>this.checkout()}>登出</Label></li>
        </ul>
      )
      : (
        <ul style={TitleLoginStyle}>
          <li style={TitleLoginStyle}><Label style={TitleLoginStyle} onClick={()=>this.setState({pageName: pageList.register})}>注册</Label></li>
          <li style={TitleLoginStyle}><Label style={TitleLoginStyle}>|</Label></li>
          <li style={TitleLoginStyle}><Label style={TitleLoginStyle} onClick={()=>this.gotoLogin()}>登录</Label></li>
        </ul>
      );

    const loginPart = !this.state.loginStatus && this.state.showLoginPart && (this.state.pageName == pageList.login)
      ? (
        <LoginPage changeLoginStatus={(val,usr,nic) => this.changeLoginStatus(val,usr,nic)} />
      )
      : undefined;

    const pagePart = this.getPage();

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
                <DefaultButton style={TitleButtonStyle} text="返回首页" onClick={()=>this.hideLogin()}/>
              </Link>
            </li>
            <li style={TitleButtonStyle}>
              <Link to="/touhouairline_Web_exploded/info">
                <DefaultButton style={TitleButtonStyle} text="航班信息" onClick={()=>this.hideLogin()} />
              </Link>
            </li>
            <li style={TitleButtonStyle}>
              <Link to="/touhouairline_Web_exploded/aboard">
                <DefaultButton style={TitleButtonStyle} text="在线值机" onClick={()=>this.hideLogin()} />
              </Link>
            </li>
            <li style={TitleButtonStyle}>
              <Link to="/touhouairline_Web_exploded/login">
                <DefaultButton style={TitleButtonStyle} text="会员服务" onClick={()=>this.gotoLogin()} />
              </Link>
            </li>
          </ul>
        </div>
        {loginPart}
        {pagePart}
      </div>
    );
  }
}

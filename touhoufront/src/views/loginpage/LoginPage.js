/* eslint-disable */
import React from 'react';
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
  TextField, PrimaryButton
} from 'office-ui-fabric-react';

import '../../App.css';

class LoginPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      password: "",
      loginStatus: false
    };
  }

  handleInputChange = (name, value) => {
    console.log(value);
    this.setState({
      [name]: value
    });
  }
  
  handleClick = () => {
    const usn = this.state.username;
    const pwd = this.state.password;
    axios.post('home', {
      params: {
        username: usn,
        password: pwd
      }
    })
    .then(function (response) {
        console.log(response.data);
      })
  }

  render() {
    return (
      <div className="App">
        <div>
          <TextField label="用户名" onChange={e => this.handleInputChange('username', e.target.value)} />
          <TextField label="密码" onChange={e => this.handleInputChange('password', e.target.value)} />
          <PrimaryButton onClick={this.handleClick}>登录</PrimaryButton>
        </div>
      </div>
    );
  }
}
export default LoginPage;
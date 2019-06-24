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
import { Button } from 'office-ui-fabric-react';

class HomePage extends React.Component {
  gotoHomePage() {
    axios.post('home', {
      params: {
        id:'12345'
      }
    })
      .then(function (response) {
        console.log(response);
        console.log(response.data);
      })
  }
  render() {
    return (
      <div>
        <Button
          text="首页"
          ariaDescription="前往首页"
          onClick={this.gotoHomePage}
        />
        <Button
          text="GayHub"
          ariaDescription="前往GayHub"
          onClick={this.gotoHomePage}
        />
      </div>
    );
  }
}
export default HomePage;
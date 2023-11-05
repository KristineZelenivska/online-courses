import React, { Component } from "react";
import { Link, Navigate } from "react-router-dom";
import { Card, CardTitle, Button, Label, Input } from "reactstrap";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import { get } from "lodash";
import { getUserData, createNewUser } from "../redux/actions/authAction.js";

const actionToProps = (dispatch) => ({
  actions: bindActionCreators({ getUserData, createNewUser }, dispatch),
});

const mapStateToProps = (state) => ({
  user: get(state, "auth.model", []),
});

class AuthPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLogIn: false,
      redirectUser: false,
    };
  }

  handleSubmit = (values) => {
    if (this.state.isLogIn) {
      this.props.actions.getUserData(this.state.email, this.toggleRedirect);
    } else {
      const { name, surname, email, password } = values;
      const data = {
        name,
        surname,
        email,
        password,
      };
      this.props.actions.createNewUser(data, this.toggleRedirect);
    }
  };

  toggleRedirect = () => {
    this.setState({ redirectUser: true });
  };

  toggleFormState = () => {
    this.setState({ isLogIn: !this.state.isLogIn });
  };

  render() {
    const containerStyle = {
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
      minHeight: "100vh", // Center vertically on the page
    };

    const contentStyle = {
      textAlign: "center",
    };

    const inputStyle = {
      marginTop: "10px",
      marginBottom: "10px",
    };

    return (
      <div style={containerStyle}>
        <div style={contentStyle}>
          <h1 style={{ padding: "30px" }}> Welcome to Learning 2.0</h1>
          {this.state.isLogIn ? (
            <Card body>
              <CardTitle tag="h3">Sign in</CardTitle>
              {/* <form> */}
              <form onSubmit={this.handleSubmit}>
                <Input
                  style={inputStyle}
                  id="emailId"
                  name="email"
                  placeholder="Email"
                  type="email"
                  value={this.state.email}
                />
                <Input
                  style={inputStyle}
                  id="passwordId"
                  name="password"
                  placeholder="Password"
                  type="password"
                />
                <Button
                  // onClick={() => this.handleSubmit()}
                  color="primary"
                  size="lg"
                  type="submit"
                >
                  Log in
                </Button>
              </form>
              <p>
                Don't have an account yet?{" "}
                <Link onClick={() => this.toggleFormState()}>Register now</Link>
              </p>
            </Card>
          ) : (
            <Card body>
              <CardTitle tag="h3">Create account</CardTitle>
              <form onSubmit={this.handleSubmit}>
                <Input
                  style={inputStyle}
                  id="nameId"
                  name="name"
                  placeholder="Name"
                  type="text"
                />
                <Input
                  style={inputStyle}
                  id="surnameId"
                  name="surname"
                  placeholder="Surname"
                  type="text"
                />
                <Input
                  style={inputStyle}
                  id="emailId"
                  name="email"
                  placeholder="Email"
                  type="email"
                />
                <Input
                  style={inputStyle}
                  id="passwordId"
                  name="password"
                  placeholder="Password"
                  type="password"
                />
                <Input
                  style={inputStyle}
                  id="repeatPassId"
                  name="repeatPass"
                  placeholder="Repeat password"
                  type="password"
                />
                <span style={inputStyle}>
                  <Input id="termsAndConditions" name="terms" type="checkbox" />{" "}
                  <Label for="termsAndConditions">
                    I agree with Terms&Conditions
                  </Label>
                </span>
                <br />
                <Button
                  onClick={() =>
                    this.handleSubmit({
                      name: "a",
                      surname: "b",
                      email: "c@kd.c",
                      password: "111",
                    })
                  }
                  // type="submit"
                  color="primary"
                  size="lg"
                >
                  Register
                </Button>
              </form>
              <p>
                Already have an account?{" "}
                <Link onClick={() => this.toggleFormState()}>Go to log in</Link>
              </p>
            </Card>
          )}
        </div>
        {this.state.redirectUser ? <Navigate to="/search"></Navigate> : null}
      </div>
    );
  }
}

export default connect(mapStateToProps, actionToProps)(AuthPage);

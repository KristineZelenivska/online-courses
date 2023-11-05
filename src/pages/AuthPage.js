import React, { Component } from "react";
import { Link, Navigate } from "react-router-dom";
import { Card, CardTitle, Button, Label, Input } from "reactstrap";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import { getUserData, createNewUser } from "../redux/actions/authAction.js";

const actionToProps = (dispatch) => ({
  actions: bindActionCreators({ getUserData, createNewUser }, dispatch),
});

const mapStateToProps = (state) => ({
  // user: get(state, "auth.model", []),
});

class AuthPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLogIn: false,
      redirectUser: false,
    };
  }

  handleSubmit = (e) => {
    e.preventDefault();
    const values = new FormData(e.target);

    if (this.state.isLogIn) {
      const data = {
        email: values.get("email"),
        password: values.get("password"),
      };
      this.props.actions.getUserData(data, this.toggleRedirect);
    } else {
      const data = {
        name: values.get("name"),
        surname: values.get("surname"),
        email: values.get("email"),
        password: values.get("password"),
      };
      this.props.actions.createNewUser(data, this.toggleFormState);
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
              <form onSubmit={this.handleSubmit}>
                <Input
                  style={inputStyle}
                  name="email"
                  placeholder="Email"
                  type="email"
                  value={this.state.email}
                />
                <Input
                  style={inputStyle}
                  name="password"
                  placeholder="Password"
                  type="password"
                />
                <Button color="primary" size="lg">
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
                  name="name"
                  placeholder="Name"
                  type="text"
                />
                <Input
                  style={inputStyle}
                  name="surname"
                  placeholder="Surname"
                  type="text"
                />
                <Input
                  style={inputStyle}
                  name="email"
                  placeholder="Email"
                  type="email"
                />
                <Input
                  style={inputStyle}
                  name="password"
                  placeholder="Password"
                  type="password"
                />
                <Input
                  style={inputStyle}
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
                <Button color="primary" size="lg">
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

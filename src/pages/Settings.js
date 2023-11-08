import React, { Component } from "react";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import { Button, ListGroup, Nav, NavItem, NavLink, Input } from "reactstrap";
import { Link } from "react-router-dom";
import { Header } from "./Header";
import { get } from "lodash";

const actionToProps = (dispatch) => ({
  actions: bindActionCreators({}, dispatch),
});

const mapStateToProps = (state) => ({
  user: get(state, "auth.user", {}),
});

class Settings extends Component {
  constructor() {
    super();
    this.state = {
      buttonText: "Edit",
      disableInputs: true,
    };
  }

  onButtonClick = () => {
    this.toggleFormState();
  };
  toggleFormState = () => {
    const text = this.state.buttonText === "Edit" ? "Save" : "Edit";
    this.setState({
      buttonText: text,
      disableInputs: !this.state.disableInputs,
    });
  };

  render() {
    const containerStyle = {
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
      minHeight: "50vh", // Center vertically on the page
    };

    const inputStyle = {
      marginTop: "10px",
      marginBottom: "10px",
    };
    const { user } = this.props;
    return (
      <div>
        <Header title="Profile Page" />
        <br />
        <ListGroup>
          <Nav
            tabs
            style={{
              display: "flex",
              justifyContent: "flex-end",
            }}
          >
            <NavItem>
              <NavLink tag={Link} to="/profile/myCourses">
                My courses
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={Link} to="/profile/myCertificates">
                My certificates
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={Link} to="/profile/settings" active>
                Settings
              </NavLink>
            </NavItem>
          </Nav>
          <h3
            style={{
              display: "flex",
              justifyContent: "center",
            }}
          >
            Settings
          </h3>

          <div style={containerStyle}>
            <form onSubmit={this.handleSubmit}>
              <Input
                style={inputStyle}
                name="name"
                type="text"
                value={user.name}
                disabled={this.state.disableInputs}
              />
              <Input
                style={inputStyle}
                name="surname"
                type="text"
                value={user.surname}
                disabled={this.state.disableInputs}
              />
              <Input
                style={inputStyle}
                name="dob"
                type="text"
                value={user.birthDay || ""}
                disabled={this.state.disableInputs}
              />
              <Input
                style={inputStyle}
                name="email"
                type="email"
                value={user.user.email}
                disabled={this.state.disableInputs}
              />
              <br />
              <Button color="primary" size="lg" onClick={this.onButtonClick}>
                {this.state.buttonText}
              </Button>
            </form>
          </div>
        </ListGroup>
      </div>
    );
  }
}

export default connect(mapStateToProps, actionToProps)(Settings);

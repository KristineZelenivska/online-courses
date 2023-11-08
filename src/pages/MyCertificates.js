import React, { Component } from "react";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import { ListGroup, Nav, NavItem, NavLink } from "reactstrap";
import { Link } from "react-router-dom";
import { Header } from "./Header";
import { get } from "lodash";

const actionToProps = (dispatch) => ({
  actions: bindActionCreators({}, dispatch),
});

const mapStateToProps = (state) => ({
  user: get(state, "auth.user", {}),
});

const dummyCourses = [
  {
    id: "123234567",
    name: "Some name",
    category: "Tech",
    teacher: "teacher's name",
    description:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddo eiusmod tempor incididunt ut labore et dolore magnaaliqua. Ut enim ad minim veniam, quis nostrud exercitationullamco laboris nisi ut aliquip ex ea commodo consequat.Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sioccaecat cupidatat non proident, sunt in culpa qui officiadeserunt mollit anim id est laborum.",
  },
  {
    id: "12323456",
    name: "Some name",
    category: "IT",
    teacher: "teacher's name",
    description: " Some long long texts",
  },
  {
    id: "12323457",
    name: "Some name",
    category: "Art",
    teacher: "teacher's name",
    description: " Some long long texts",
  },
  {
    id: "12323467",
    name: "Some name",
    category: "Some other",
    teacher: "teacher's name",
    description: " Some long long texts",
  },
];
class MyCertificates extends Component {
  constructor() {
    super();
    this.state = {};
  }

  render() {
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
              <NavLink tag={Link} to="/profile/myCertificates" active>
                My certificates
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={Link} to="/profile/settings">
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
            My Certificates
          </h3>
          {/* somehow display certifiactes here */}
        </ListGroup>
      </div>
    );
  }
}

export default connect(mapStateToProps, actionToProps)(MyCertificates);

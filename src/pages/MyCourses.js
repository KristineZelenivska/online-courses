import React, { Component } from "react";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import {
  Row,
  Col,
  Button,
  ListGroup,
  ListGroupItem,
  ListGroupItemHeading,
  ListGroupItemText,
  Nav,
  NavItem,
  NavLink,
} from "reactstrap";
import { Icon } from "@iconify/react";
import { Header } from "./Header";
import { get } from "lodash";
import { Link, Navigate } from "react-router-dom";

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
class MyCourses extends Component {
  constructor() {
    super();
    this.state = {
      openCourse: false,
    };
  }
  openCourse = () => {
    this.setState({ openCourse: true });
  };
  render() {
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
              <NavLink tag={Link} to="/profile/myCourses" active>
                My courses
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={Link} to="/profile/myCertificates">
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
            My courses
          </h3>
          {user.personCourses.length > 0 ? (
            user.personCourses.map((course) => (
              <ListGroupItem key={course.id} style={{ margin: "10px" }}>
                <Row>
                  <Col
                    xs="1"
                    style={{
                      display: "flex",
                      justifyContent: "center",
                    }}
                  >
                    <img alt="Sample" src="https://picsum.photos/150/150" />
                  </Col>
                  <Col>
                    <ListGroupItemHeading>{course.name}</ListGroupItemHeading>
                    <ListGroupItemText>{course.description}</ListGroupItemText>
                    <span>{course.teacher}</span>
                  </Col>
                  <Col
                    xs="1"
                    style={{
                      display: "flex",
                      flexWrap: "wrap",
                      alignContent: "space-around",
                      justifyContent: "center",
                    }}
                  >
                    <ListGroupItemHeading>
                      {course.category}
                    </ListGroupItemHeading>
                    <Button outline onClick={this.openCourse}>
                      Open course
                      <Icon
                        icon="icon-park:right"
                        style={{ fontSize: "15px" }}
                      />
                    </Button>
                  </Col>
                </Row>
              </ListGroupItem>
            ))
          ) : (
            <div
              style={{
                display: "flex",
                justifyContent: "center",
              }}
            >
              <h5>You do not have any course yet</h5>
            </div>
          )}
        </ListGroup>
        {this.state.openCourse ? (
          <Navigate to="/search/course"></Navigate>
        ) : null}
      </div>
    );
  }
}

export default connect(mapStateToProps, actionToProps)(MyCourses);

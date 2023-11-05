import React, { Component } from "react";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import {
  Row,
  Col,
  Button,
  Input,
  ListGroup,
  ListGroupItem,
  ListGroupItemHeading,
  ListGroupItemText,
} from "reactstrap";
import { Icon } from "@iconify/react";
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
class SearchPage extends Component {
  constructor() {
    super();
    this.state = {};
  }

  render() {
    return (
      <div>
        <Header />
        <br />
        <form>
          <Row style={{ margin: "5px" }}>
            <Col xs="7">
              <Input
                id="exampleSearch"
                name="search"
                placeholder="search placeholder"
                type="search"
              />
            </Col>
            <Col xs="2">
              <Input className="mb-3" type="select">
                <option>Default Select</option>
              </Input>
            </Col>
            <Col xs="2">
              <Input className="mb-3" type="select">
                <option>Default Select</option>
              </Input>
            </Col>
            <Col>
              <Button>Search</Button>
            </Col>
          </Row>
        </form>
        {/* row for search result */}
        <ListGroup>
          {dummyCourses.map((course) => (
            <ListGroupItem key={course.id} style={{ margin: "10px" }}>
              <Row>
                <Col xs="1">
                  <img alt="Sample" src="https://picsum.photos/150/150" />
                </Col>
                <Col>
                  <ListGroupItemHeading>
                    {course.name}
                    <span style={{ float: "right" }}>{course.category}</span>
                  </ListGroupItemHeading>
                  <ListGroupItemText>{course.description}</ListGroupItemText>
                  <span>{course.teacher}</span>
                  <Button outline style={{ float: "right" }}>
                    Go to Course
                    <Icon icon="icon-park:right" style={{ fontSize: "20px" }} />
                  </Button>
                </Col>
              </Row>
            </ListGroupItem>
          ))}
        </ListGroup>
      </div>
    );
  }
}

export default connect(mapStateToProps, actionToProps)(SearchPage);

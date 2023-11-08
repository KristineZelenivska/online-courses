import React, { Component } from "react";
import {
  Button,
  Row,
  Col,
  ListGroup,
  ListGroupItem,
  ListGroupItemText,
} from "reactstrap";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import { getUserData, createNewUser } from "../redux/actions/authAction.js";
import { get } from "lodash";
import { Header } from "./Header";
import { Icon } from "@iconify/react";

const actionToProps = (dispatch) => ({
  actions: bindActionCreators({ getUserData, createNewUser }, dispatch),
});

const mapStateToProps = (state) => ({
  course: get(state, "course.model", {
    name: "Some course name",
    description:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ac ante vel justo mattis volutpat. Suspendisse potenti. Nulla facilisi. In eu libero a erat vulputate bibendum. Proin non ex nec risus consectetur dictum. Morbi facilisis, erat non congue bibendum, justo lectus dictum metus, ut dignissim metus elit a leo. Sed vel feugiat mi.",
  }), // course info here
});

const reviews = [
  {
    user: "userName",
    stars: 5,
    date: "08.11.2023",
    comment: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
  },
  {
    user: "userName",
    stars: 3,
    date: "15.12.2018",
    comment:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit.Lorem ipsum dolor sit amet, consectetur adipiscing elit.Lorem ipsum dolor sit amet, consectetur adipiscing elit.Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
  },
  {
    user: "userName",
    stars: 1,
    date: "03.03.2022",
    comment: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
  },
  {
    user: "userName",
    stars: 4,
    date: "03.03.2022",
    comment: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
  },
  {
    user: "userName",
    stars: 5,
    date: "03.03.2022",
    comment: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
  },
];
class CoursePage extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  startCourse = () => {
    console.log("starting course");
  };

  render() {
    const { course } = this.props;
    return (
      <div>
        <Header title={course.name} />
        <br />
        <ListGroup>
          <ListGroupItem style={{ margin: "10px" }}>
            <Row>
              <Col>
                <Row>
                  <h3
                    style={{
                      display: "flex",
                      justifyContent: "space-evenly",
                    }}
                  >
                    <span>Category</span>
                    <span>Teacher</span>
                    <span style={{ display: "flex", alignItems: "center" }}>
                      50.00
                      <Icon
                        icon="streamline:money-currency-bitcoin-circle-1-crypto-circle-payment-blockchain-finance-bitcoin-currency-money"
                        style={{ fontSize: "20px" }}
                      />
                    </span>
                  </h3>
                </Row>
                <Row style={{ margin: "25px" }}>
                  <p style={{ fontSize: "18px" }}>
                    {course.description}
                    {course.description}
                    {course.description}
                    {course.description}
                  </p>
                </Row>
              </Col>
              <Col
                xs="3"
                style={{
                  display: "flex",
                  flexWrap: "wrap",
                  flexDirection: "column",
                  alignContent: "center",
                }}
              >
                <Icon icon="arcticons:git" style={{ fontSize: "300px" }} />
                <Button size="lg" color="success" onClick={this.startCourse}>
                  Enroll
                </Button>
              </Col>
            </Row>
          </ListGroupItem>
        </ListGroup>
        <ListGroup>
          <ListGroupItem style={{ marginLeft: "10px", marginRight: "10px" }}>
            <h4>Reviews</h4>
            <Row>
              {reviews.map((review, i) => (
                <ListGroupItem key={i} style={{ margin: "10px" }}>
                  <Row>
                    <Col
                      xs="1"
                      style={{
                        display: "flex",
                        flexDirection: "column",
                        alignItems: "center",
                      }}
                    >
                      <h5 style={{ margin: "0px" }}>{review.user}</h5>
                      <span>
                        {Array(review.stars)
                          .fill(null)
                          .map((data, i) => (
                            <Icon
                              key={i}
                              color="orange"
                              icon="clarity:star-solid"
                            />
                          ))}
                      </span>
                    </Col>
                    <Col>
                      <ListGroupItemText>{review.comment}</ListGroupItemText>
                    </Col>
                    <Col xs="1">
                      <p>{review.date}</p>
                    </Col>
                  </Row>
                </ListGroupItem>
              ))}
            </Row>
          </ListGroupItem>
        </ListGroup>
      </div>
    );
  }
}

export default connect(mapStateToProps, actionToProps)(CoursePage);

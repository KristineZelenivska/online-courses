import React, { Component } from "react";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";

const actionToProps = (dispatch) => ({
  actions: bindActionCreators({}, dispatch),
});

const mapStateToProps = (state) => ({});

class SearchPage extends Component {
  constructor() {
    super();
    this.state = {};
  }

  render() {
    return (
      <div>
        <h1>Search Course</h1>
      </div>
    );
  }
}

export default connect(mapStateToProps, actionToProps)(SearchPage);

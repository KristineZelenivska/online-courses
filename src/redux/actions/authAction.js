import Axios from "axios";

export function getUserData(data, cb) {
  return (dispatch) => {
    let url = `http://localhost:8080/auth/login`;
    Axios.post(url, data)
      .then((res) => {
        dispatch({
          type: "GET_USER_SUCCESS",
          payload: res.data,
        });
        cb && cb();
      })
      .catch((err) => {
        dispatch({
          type: "GET_USER_ERROR",
        });
      });
    return dispatch({
      type: "GET_USER_START",
    });
  };
}

export function createNewUser(data, cb) {
  return (dispatch) => {
    let url = `http://localhost:8080/auth/addNewUser`;
    Axios.post(url, data)
      .then((res) => {
        dispatch({
          type: "POST_USER_SUCCESS",
          payload: res.data,
        });
        cb && cb();
      })
      .catch((err) => {
        dispatch({
          type: "POST_USER_ERROR",
        });
      });
    return dispatch({
      type: "POST_USER_START",
    });
  };
}

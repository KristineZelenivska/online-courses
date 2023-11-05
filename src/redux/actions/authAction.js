import Axios from "axios";

export function getUserData(email, cb) {
  return (dispatch) => {
    let url = `http://localhost:8080/auth/user/userProfile/${email}`;
    Axios.get(url)
      .then((res) => {
        dispatch({
          type: "GET_USER_SUCCESS",
          payload: res.data,
        });
        // cb && cb();
      })
      .catch((err) => {
        dispatch({
          type: "GET_USER_ERROR",
        });
        // cb && cb(); //this to be deleted
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
        console.log(222222, res);
        // cb && cb();
      })
      .catch((err) => {
        dispatch({
          type: "POST_USER_ERROR",
        });
        // cb && cb(); //this to be deleted
      });
    return dispatch({
      type: "POST_USER_START",
    });
  };
}

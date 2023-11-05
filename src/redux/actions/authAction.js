import Axios from "axios";

export function getUserData(data, cb) {
  return (dispatch) => {
    let url = `http://localhost:8080/auth/user/userProfile`;
    Axios.get(url)
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
        cb && cb(); //this to be deleted
      });
    return dispatch({
      type: "GET_USER_START",
    });
  };
}

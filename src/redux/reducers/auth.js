const initialState = {
  user: {},
};

export default function authUser(state = initialState, { type, payload }) {
  switch (type) {
    case "GET_USER_SUCCESS":
      return {
        ...state,
        user: payload,
      };
    case "GET_USER_ERROR":
      return state;
    default:
      return state;
  }
}

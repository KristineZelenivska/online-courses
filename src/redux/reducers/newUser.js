const initialState = "";

export default function createUser(state = initialState, { type, payload }) {
  switch (type) {
    case "POST_USER_SUCCESS":
      return payload;
    case "POST_USER_ERROR":
      return payload;
    default:
      return state;
  }
}

const initialState = {
  model: [],
};

export default function auth(state = initialState, { type, payload }) {
  switch (type) {
    case "GET_USER_SUCCESS":
      return {
        ...state,
        model: [...state.model, payload],
      };
    case "GET_USER_ERROR":
      return {
        ...state,
        model: [...state.model],
      };
    default:
      return state;
  }
}

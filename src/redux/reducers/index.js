import { combineReducers } from "redux";

import { reducer as reduxFormReducer } from "redux-form";
import auth from "./form/auth";

export default combineReducers({
  auth,
});

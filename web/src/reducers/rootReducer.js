import { combineReducers } from "redux";
import cart from "./cartReducer";
export default combineReducers({
    _todoProduct: cart
});

import {combineReducers} from "redux";
import productReducer from "./ProductModules";
import memberReducer from "./MemberModules";

const rootReducer = combineReducers({
    productReducer, memberReducer
});

export default rootReducer;
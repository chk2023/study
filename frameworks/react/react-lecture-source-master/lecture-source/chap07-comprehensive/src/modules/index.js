import {combineReducers} from "redux";
import productReducer from "./ProductModules";
import memberReducer from "./MemberModules";
import orderReducer from "./OrderModules";

const rootReducer = combineReducers({
    productReducer, memberReducer, orderReducer
});

export default rootReducer;
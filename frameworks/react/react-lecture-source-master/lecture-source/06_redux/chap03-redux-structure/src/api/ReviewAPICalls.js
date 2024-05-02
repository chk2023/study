import {request} from "./api";
import {getReviewlist} from "../modules/ReviewModules";

export function callGetReviewListAPI() {

    return async (dispatch, getState) => {

        const result = await request('GET', '/review');

        dispatch(getReviewlist(result));
    }
}
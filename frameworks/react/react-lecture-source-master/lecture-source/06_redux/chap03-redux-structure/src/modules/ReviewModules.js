/* 초기값 */
import {createActions, handleActions} from "redux-actions";

const initialState = {};

/* 액션 타입 */
const GET_REVIEWLIST = 'review/GET_REVIEWLIST';

/* 액션 함수 */
export const { review : { getReviewlist } } = createActions({
    [GET_REVIEWLIST] : result => ({reviewlist : result})
});

/* 리듀서 함수 */
const reviewReducer = handleActions({
    [GET_REVIEWLIST] : (state, { payload }) => payload,
}, initialState);

export default reviewReducer;













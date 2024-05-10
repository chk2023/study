/* 초기값 */
import {createActions, handleActions} from "redux-actions";

const initialState = {};

/* 액션 타입 */
const SUCCESS = 'member/SUCCESS';
const RESET = 'member/RESET';

/* 액션 함수 */
export const { member : { success, reset }} = createActions({
    [SUCCESS] : () => ({ success : true }),
    [RESET] : () => {},
});

/* 리듀서 함수 */
const memberReducer = handleActions({
    [SUCCESS] : (state, { payload }) => payload,
    [RESET] : () => initialState
}, initialState);

export default memberReducer;







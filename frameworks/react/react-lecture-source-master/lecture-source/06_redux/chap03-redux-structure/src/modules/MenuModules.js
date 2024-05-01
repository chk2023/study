import {createActions, handleActions} from "redux-actions";

/* 초기 값 */
const initialState = {};

/* 액션 */
const GET_MENULIST = 'menu/GET_MENULIST';

export const { menu : { getMenulist } } = createActions({
   [GET_MENULIST] : result => ({ menulist : result })
});

/* 리듀서 함수 */
const menuReducer = handleActions({
   [GET_MENULIST] : (state, { payload }) => payload
}, initialState);

export default menuReducer;
import {createActions, handleActions} from "redux-actions";

/* 초기값 */
const initialState = {};
/* 액션 타입 */
const GET_PRODUCTS = 'product/GET_PRODUCTS';
/* 액션 함수 */
export const { product : { getProducts } } = createActions( {
    [GET_PRODUCTS] : result => ({ products : result.data })
})
/* 리듀서 함수 */
const productReducer = handleActions({
    [GET_PRODUCTS] : (state, {payload}) => payload
}, initialState);

export default productReducer;
import {createActions, handleActions} from "redux-actions";

/* 초기값 */
const initialState = {};
/* 액션 타입 */
const GET_PRODUCTS = 'product/GET_PRODUCTS';
const GET_PRODUCT = 'product/GET_PRODUCT';
/* 액션 함수 */
export const { product : { getProducts, getProduct }} = createActions({
    [GET_PRODUCTS] : result => ({products : result.data }),
    [GET_PRODUCT] : result => ({product : result.data })
})
/* 리듀서 함수 */
const productReducer = handleActions({
    [GET_PRODUCTS] : (state, {payload}) => payload,
    [GET_PRODUCT] : (state, {payload}) => payload
}, initialState);

export default productReducer;
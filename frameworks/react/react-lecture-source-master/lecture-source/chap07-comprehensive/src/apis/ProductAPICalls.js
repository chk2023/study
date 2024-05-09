import {request} from "./api";
import {getProduct, getProducts} from "../modules/ProductModules";

export const callProductListAPI = ({ currentPage = 1}) => {

    return async (dispatch, getState) => {
        const result = await request('GET', `/api/v1/products?page=${currentPage}`);
        console.log('callProductListAPI result : ',result);

        if(result.status === 200) {
            dispatch(getProducts(result));
        }

    }
};

export const callProductCategoryListAPI = ({ categoryCode, currentPage = 1 }) => {

    return async (dispatch, getState) => {

        const result = await request('GET', `/api/v1/products?categoryCode=${categoryCode}&page=${currentPage}`);
        console.log('callProductCategoryListAPI result : ', result);

        if(result.status === 200) {
            dispatch(getProducts(result));
        }

    }
};

export const callProductSearchListAPI = ({ productName, currentPage = 1 }) => {

    return async (dispatch, getState) => {

        const result = await request('GET', `/api/v1/products?productName=${productName}&page=${currentPage}`);
        console.log('callProductSearchListAPI result : ', result);

        if(result.status === 200) {
            dispatch(getProducts(result));
        }

    }
};

export const callProductDetailAPI = ({ productCode }) => {

    return async (dispatch, getState) => {

        const result = await request('GET', `/api/v1/products/${productCode}`);
        console.log('callProductDetailAPI result : ', result);

        if(result.status === 200) {
            dispatch(getProduct(result));
        }

    }
};







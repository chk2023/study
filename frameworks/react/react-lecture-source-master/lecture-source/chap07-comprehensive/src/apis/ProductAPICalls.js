import {request} from "./api";
import {getProducts} from "../modules/ProductModules";

export const callProductListAPI = ({ currentPage = 1}) => {

    return async (dispatch, getState) => {
        const result = await request('GET', `/api/v1/products?page=${currentPage}`);
        console.log('callProductListAPI result : ',result);

        if (result.status === 200) {
            dispatch(getProducts(result));
        }

    }
};

export const callFoodCategoryAPI = ({ currentPage = 1 }) => {

    return async (dispatch, getState) => {
        const result = await request('GET' `api/v1/products?page=${currentPage}&categoryCode=${categoryCode}`);
    }
};
import {authRequest, request} from "./api";
import {toast} from "react-toastify";
import {removeToken, saveToken} from "../utils/TokenUtils";
import {useNavigate} from "react-router-dom";
import {success} from "../modules/MemberModules";

export const callSignupAPI = ({signupRequest}) => {


    return async (dispatch, getState) => {
        const result = await request(
            'POST',
            '/api/v1/members/signup',
            {'Content-Type' : 'application/json' },
            JSON.stringify(signupRequest)
        );

        console.log('callSignupAPI result : ', result);

        if(result?.status === 201) {
            dispatch(success());
        } else {
            toast.warning("회원 가입에 실패했습니다. 다시 시도해주세요.");
        }

    }
}

export const callLoginAPI = ({loginRequest}) => {


    return async (dispatch, getState) => {
        const result = await request(
            'POST',
            '/api/v1/members/login',
            {'Content-Type' : 'application/json' },
            JSON.stringify(loginRequest)
        );

        console.log('callLoginAPI result : ', result);

        if(result?.status === 200) {
            saveToken(result.headers);
            dispatch(success());
        } else {
            toast.warning("로그인에 실패하였습니다. 아이디와 비밀번호를 확인해주세요.");
        }



    }
}

export const callLogoutAPI = () => {

    return async (dispatch, getState) => {

        const result = await authRequest.post(`/api/v1/members/logout`);
        console.log('callLogoutAPI result : ', result);

        if(result.status === 200) {
            removeToken();
            dispatch(success());
        }

    }
}













import {request} from "./api";
import {toast} from "react-toastify";
import {saveToken} from "../utils/TokenUtils";

export const callSignupAPI = ({signupRequest}) => {
    return async (dispatch, getState) => {
        const result = await request(
            'POST',
            '/api/v1/members/signup',
            {'Content-Type' : 'application/json'},
            JSON.stringify(signupRequest)
        );
        console.log('callSignupAPI result : ', result);

        if (result?.status === 201) {
            saveToken(result.headers);
        } else {
            toast.warning("회원 가입에 실패하였습니다. 다시 시도해주세요.");
        }





    }
}
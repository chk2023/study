import SignupForm from "../../components/form/SignupForm";
import {ToastContainer} from "react-toastify";

function Signup() {
    return (
        <>
            <ToastContainer hideProgressBar={true} position="top-center"/>
            <div className="background-div">
                <div className="signup-div">
                    <SignupForm/>
                </div>
            </div>
        </>
    );
}

export default Signup;
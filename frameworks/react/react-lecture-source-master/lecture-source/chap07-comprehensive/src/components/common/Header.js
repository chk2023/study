import {useNavigate} from "react-router-dom";

function Header() {

    const navigate = useNavigate();

    /* 로고 클릭 시 메인 페이지로 이동 */
    const onClickHandler = () => navigate("/");

    return (
        <div className="header-div">
            <button
                className="logo-btn"
                onClick={ onClickHandler }
            >
                OHGIRAFFERS
            </button>
            <input
                className="input-style"
                type="text"
                placeholder="검색"
            />
        </div>
    );
}

export default Header;
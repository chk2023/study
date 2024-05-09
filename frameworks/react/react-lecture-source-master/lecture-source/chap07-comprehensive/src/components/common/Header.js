import {useNavigate} from "react-router-dom";
import {useState} from "react";

function Header() {

    const navigate = useNavigate();
    const [search, setSearch] = useState('');


    /* 로고 클릭 시 메인 페이지로 이동 */
    const onClickHandler = () => navigate("/");
    const onEnterKeyHandler = e => {
        if(e.key === 'Enter') navigate(`/product/search?value=${search}`);
    }

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
                onChange={ e => setSearch(e.target.value) }
                onKeyUp={ onEnterKeyHandler }
                value={ search }
            />
        </div>
    );
}

export default Header;
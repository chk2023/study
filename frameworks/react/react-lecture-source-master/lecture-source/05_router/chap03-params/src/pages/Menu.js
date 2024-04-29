import {useEffect, useState} from "react";
import {getMenuList} from "../api/MenuAPI";
import boxStyle from "./Menu.module.css";
import MenuItem from "../components/MenuItem";

/* 일반 css 파일을 이용하면 작업물을 합쳤을 때 class name conflict로 인해 디자인이 변경 되는 경우가 있다.
* module.css 파일은 class 명에 랜덤한 문자를 붙여 class name conflict를 방지한다.*/
function Menu() {

    const [menuList, setMenuList] = useState();

    useEffect(() => {
        /* 메뉴 목록 조회 => MenuAPI.js 파일을 만들어서 API 호출 함수를 모아둔다. */
        setMenuList(getMenuList());
    }, []);

    return (
        <div>
            <h1>메뉴 목록</h1>

            <div className={boxStyle.MenuBox}>
                { menuList && menuList.map(menu => <MenuItem key={menu.menuCode} menu={menu}/>) }
            </div>
        </div>
    );
}

export default Menu;
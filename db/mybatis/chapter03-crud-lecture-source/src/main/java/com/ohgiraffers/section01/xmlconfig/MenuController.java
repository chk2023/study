package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class MenuController {

    private final MenuService menuService; //controller 안에서 여러 메소드가 service를 사용할 수 있게 전역변수로 선언.
    private final PrintResult printResult;

    public MenuController() { //final이 붙어서 service를 초기화해주어야 한다. 생성자에서 초기화를 한다.
        menuService = new MenuService();
        printResult = new PrintResult();
    }
    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();

        if (menuList != null) {
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }
}

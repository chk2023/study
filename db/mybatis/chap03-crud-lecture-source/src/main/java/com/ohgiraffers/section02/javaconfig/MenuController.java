package com.ohgiraffers.section02.javaconfig;

import java.util.List;
import java.util.Map;

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

    public void selectMenuByMenuCode(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menu = menuService.selectMenuByMenuCode(menuCode);

        if (menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }


    public void registMenu(Map<String, String> parameter) {

        /* 넘어온 데이터 가공 */
        MenuDTO menu = new MenuDTO();
        menu.setMenuName(parameter.get("menuName"));
        menu.setMenuPrice(Integer.parseInt(parameter.get("menuPrice")));
        menu.setMenuCategoryCode(Integer.parseInt(parameter.get("categoryCode")));

        if (menuService.registMenu(menu)) { //registMenu()는 T or F를 반환하는 메서드
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyMenu(Map<String, String> parameter) {

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(Integer.parseInt(parameter.get("menuCode")));
        menu.setMenuName(parameter.get("menuName"));
        menu.setMenuPrice(Integer.parseInt(parameter.get("menuPrice")));
        menu.setMenuCategoryCode(Integer.parseInt(parameter.get("categoryCode")));

        if (menuService.modifyMenu(menu)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(Map<String, String> parameter) {

        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        if(menuService.deleteMenu(menuCode)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}






















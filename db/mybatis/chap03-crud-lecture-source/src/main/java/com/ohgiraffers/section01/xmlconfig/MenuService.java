package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuService {

    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }
    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = Template.getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = Template.getSqlSession();

        MenuDTO menu = menuDAO.selectMenuByMenuCode(sqlSession, menuCode);

        sqlSession.close();

        return menu;

    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = Template.getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);

        /* DML 구문이기 때문에 직접 commit, rollback해야 함. 현재 설정은 수동 커밋. */
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0; //result가 0보다 큰지 판단해서 T or F 반환.
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = Template.getSqlSession();

        int result = menuDAO.updateMenu(sqlSession, menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;

    }

    public boolean deleteMenu(int menuCode) {
        SqlSession sqlSession = Template.getSqlSession();

        int result = menuDAO.deleteMenu(sqlSession, menuCode);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }
}

























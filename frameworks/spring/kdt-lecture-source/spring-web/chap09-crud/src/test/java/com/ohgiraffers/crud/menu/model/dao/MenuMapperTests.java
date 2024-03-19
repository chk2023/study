package com.ohgiraffers.crud.menu.model.dao;

import com.ohgiraffers.crud.configuration.Chap09CrudApplication;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = { Chap09CrudApplication.class })
public class MenuMapperTests {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void 매퍼_인터페이스_의존성_주입_테스트() {
        assertNotNull(menuMapper);
    }

    @Test
    public void 전체_메뉴_조회_매퍼_테스트() {
        // given
        // when
        List<MenuDTO> menuList = menuMapper.findAllMenu();
        // then
        assertNotNull(menuList);
    }

    @Test
    @DisplayName("신규 메뉴가 잘 추가 되는지 매퍼 인터페이스의 메소드 확인")
    @Transactional // -> 테스트 코드로 수행한 작업을 테스트 완료 후 rollback 하여 DB에 남기지 않음
    public void testRegistMenu() {
        // given
        MenuDTO menu = new MenuDTO();
        menu.setMenuName("테스트쌀국수");
        menu.setMenuPrice(13000);
        menu.setCategoryCode(6);
        menu.setOrderableStatus("Y");

        // when & then
        assertDoesNotThrow(() -> menuMapper.registMenu(menu));
    }

    @Test
    @DisplayName("신규 메뉴 추가 실패 테스트")
    public void testRegistMenu2() {
        // given
        MenuDTO menu = new MenuDTO();
        menu.setMenuName("테스트실패");
        menu.setMenuPrice(13000);
        menu.setCategoryCode(100);
        menu.setOrderableStatus("Y");

        // when & then
        assertThrows(Exception.class, () -> menuMapper.registMenu(menu));
    }







}

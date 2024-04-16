package com.ohgiraffers.associationmapping.section01.manytoone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ManyToOneServiceTests {

    @Autowired
    private ManyToOneService manyToOneService;

    @DisplayName("N:1 연관 관계 객체 그래프 탐색을 이용한 조회 테스트")
    @Test
    void manyToOneFindTest() {
        // given
        int menuCode = 10;

        // when
        Menu foundMenu = manyToOneService.findMenu(menuCode);

        // then
        Category category = foundMenu.getCategory();
        assertNotNull(category);
    }
    @DisplayName("N:1 연관 관계 객체 지향 쿼리(JPQL)을 이용한 조회 테스트")
    @Test
    void manyToOneJpqlFindTest() {
        // given
        int menuCode = 10;

        // when
        String categoryName = manyToOneService.findCategoryNameByJpql(menuCode);

        // then
        assertNotNull(categoryName);
        System.out.println("[Category Name] " + categoryName);

    }









}

package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryAndMenuDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDTO;

import java.util.List;

public interface ElementTestMapper {
    /*매퍼 인터페이스와 xml은 경로 동일, 파일명 동일 해야한다.
     * xml의 namespace 역시 설정. mybatis-config에서 <mapper>도 설정.
     * */
    List<String> selectCacheTest();

    List<MenuDTO> selectResultMapTest();

    List<MenuDTO> selectResultMapConstructorTest();

    List<MenuAndCategoryDTO> selectResultMapAssociationTest();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();

    List<MenuDTO> selectSqlTest();

    int insertNewCategory(MenuAndCategoryDTO menuAndCategoryDTO);

    int insertNewMenu(MenuAndCategoryDTO menuAndCategoryDTO);
}
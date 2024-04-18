package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/* <엔터티, Id타입> */
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}

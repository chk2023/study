package com.ohgiraffers.section01.scope.subsection02.prototype;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /* 슈퍼에 상품이 진열 되어 있다. */
        Product carpBread = applicationContext.getBean("carpBread", Bread.class);
        Product milk = applicationContext.getBean("milk", Beverage.class);
        Product water = applicationContext.getBean("water", Beverage.class);

        /* 한 손님이 쇼핑 카트를 꺼내 상품을 쇼핑 카트에 담는다. */
        ShoppingCart cart1 = applicationContext.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("cart1에 담긴 상품 : " + cart1.getItem());

        /* 다른 손님이 쇼핑 카트를 꺼내 상품을 쇼핑 카트에 담는다. */
        ShoppingCart cart2 = applicationContext.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2에 담긴 상품 : " + cart2.getItem());

        System.out.println("cart1의 hashcode : " + cart1.hashCode());
        System.out.println("cart2의 hashcode : " + cart2.hashCode());

        /* singleton 스코프에서 prototype 스코프로 변경하면 매번 다른 객체의 cart를 반환하므로
        손님 두 명이 각각 쇼핑 카트를 이용해 상품을 담을 수 있다.
        * */





    }
}

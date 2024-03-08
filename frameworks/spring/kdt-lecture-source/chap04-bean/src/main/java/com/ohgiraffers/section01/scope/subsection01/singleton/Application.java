package com.ohgiraffers.section01.scope.subsection01.singleton;

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

        /* Bean의 기본 스코프는 singleton이다.
        * singleton 스코프를 갖는 bean은 애플리케이션 내에서 유일한 인스턴스를 갖는다.
        * cart도 singleton으로 관리 되기 때문에 두 손님이 동일한 카트에 물건을 담은 것이 된다.
        * */





    }
}

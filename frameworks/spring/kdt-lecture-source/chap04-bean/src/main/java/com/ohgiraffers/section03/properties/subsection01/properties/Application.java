package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = applicationContext.getBean("carpBread", Bread.class);
        Product milk = applicationContext.getBean("milk", Beverage.class);
        Product water = applicationContext.getBean("water", Beverage.class);

        System.out.println("carpBread : " + carpBread);
        System.out.println("milk : " + milk);
        System.out.println("water : " + water);

    }
}

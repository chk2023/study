package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
/* resources 폴더 하위 경로를 기술한다. */
@PropertySource("section03/properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {

    /* 치환자(placeholder) 문법을 이용하여 propreties에 저장 된 key 값을 입력하면 value에 해당하는 값을 가져온다.
    * 양 옆에 공백이 있을 경우 값을 읽어오지 못하는 점을 주의한다. : 을 사용하여 대체 값을 작성할 수 있다. */
    @Value("${bread.carpbread.name:팥붕}")
    private String carpBreadName;

    @Value("${bread.carpbread.price:0}")
    private int carpBreadPrice;

    @Bean
    public Product carpBread() {
        return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
    }

    @Bean
    public Product milk(@Value("${beverage.milk.name:}") String milkName,
                        @Value("${beverage.milk.price:0}") int milkPrice,
                        @Value("${beverage.milk.capacity:0}") int capacity) {

        return new Beverage(milkName, milkPrice, capacity);
    }

    @Bean
    public Product water(@Value("${beverage.water.name:}") String waterName,
                         @Value("${beverage.water.price:0}") int waterPrice,
                         @Value("${beverage.water.capacity:0}") int capacity) {
        return new Beverage(waterName, waterPrice, capacity);
    }
}

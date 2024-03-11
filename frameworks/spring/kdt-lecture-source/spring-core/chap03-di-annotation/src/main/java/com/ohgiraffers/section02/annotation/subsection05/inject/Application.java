package com.ohgiraffers.section02.annotation.subsection05.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        /* SpringFramework 5 -> 6 버전으로 변경 되었을 때 @Named 어노테이션이 기능하지 않는 이슈로
        * pikachu가 아닌 @Primary 설정 된 charmander가 출력 되는 현상이 있음.  */
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        PokemonService pokemonService = applicationContext.getBean("pokemonServiceInject", PokemonService.class);

        pokemonService.pokemonAttack();
    }
}

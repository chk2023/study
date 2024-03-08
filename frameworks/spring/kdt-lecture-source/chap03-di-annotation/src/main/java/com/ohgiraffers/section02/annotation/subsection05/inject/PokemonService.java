package com.ohgiraffers.section02.annotation.subsection05.inject;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;

@Service("pokemonServiceInject")
public class PokemonService {

    /* @Inject 어노테이션은 자바에서 제공하는 기본 어노테이션이다.
    * @Autowired와 같은 스프링 어노테이션과 같이 Type을 통해 의존성 주입을 하며 @Named를 통해 이름을 명시할 수 있다.
    * 필드, 생성자, 세터 주입 방식을 사용할 수 있다.
    * */

    /* 1. 필드 주입 방식 */
//    @Inject
//    @Named("pikachu")  //역시나 권장 되지 않는 필드 주입
    private Pokemon pokemon;

    /* 2. 생성자 주입 방식 */
//    @Inject
//    public PokemonService(@Named("pikachu") Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }

    /* 3. setter 주입 방식 */
    @Inject
    public void setPokemon(@Named("pikachu") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}

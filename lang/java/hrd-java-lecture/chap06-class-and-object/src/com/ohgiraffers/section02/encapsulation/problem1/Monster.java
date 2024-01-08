package com.ohgiraffers.section02.encapsulation.problem1;

public class Monster {
    String name;
    int hp;

    /* setHp 라는 메소드를 이용해 필드에 간접 접근하도록 한다. */
    public void setHp(int hp) {
        if (hp > 0){
            System.out.println("양수 값이 입력되어 몬스터의 체력을 입력한 값으로 변경한다.");
            /* this는 인스턴스 변수가 생성 되었을 때 자신의 주소를 저장하는 레퍼런스 변수이다.
            * 지역 변수와 전역 변수의 이름이 동일한 경우 지역 변수를 우선적으로 접근하기 때문에
            * 전역 변수에 접근하기 위해서는 this.을 명시해야 한다. */
            this.hp = hp;
        } else {
            System.out.println("0보다 작거나 같은 값이 입력되어 몬스터의 체력을 0으로 변경한다. ");
            this.hp = 0;
        }
    }
}

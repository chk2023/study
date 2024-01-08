package com.ohgiraffers.section02.encapsulation.problem4;

public class Application4 {
    public static void main(String[] args) {
        /* 접근 제한자에 대해 이해하고 직접 필드에 접근하지 못하게 강제화 할 수 있다.*/
        Monster monster1 = new Monster();
        /* 필드에 private 접근 제한자를 붙였기 때문에 직접 접근하려고 하면 compile error 발생 */
//        monster1.kinds = "프랑켄슈타인";
//        monster1.hp = 200;

        monster1.setInfo("프랑켄슈타인");
        monster1.setHp(200);
        System.out.println(monster1.getInfo());

        /*캡슐화는 유지보수성을 증가시키기 위해 필드의 직접 접근을 제한하고
        * public 메소드를 이용해 간접적으로 접근하여 사용할 수 있도록 만든 기술이다.
        * 클래스 작성 시 특별한 목적이 아닌 이상 캡슐화가 기본 원칙으로 사용되고 있다.
        * */
    }
}

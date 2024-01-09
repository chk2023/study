package com.ohgiraffers.section05.overloading;

public class OverloadingTest {
    /* 오버 로딩에 대해 이해할 수 있다.
    * 사용 이유
    * 매개변수의 종류 별로 메소드 내용을 다르게 작성해야 하는 경우들이 종종 있는데
    * 동일 기능의 메소드를 매개변수에 따라 다른 이름을 붙이면 관리가 어렵기 때문에 사용한다.
    * EX) */

    /* 오버로딩의 조건 */
    public void test() {}

    /* 메소드 시그니처가 같으면 compile error를 발생 시킨다.
    * 메소드 시그니처란?
    * 메소드명과 파라미터 선언부를 의미하며 접근 제한자, 반환형은 오버로딩 성립 요건에 해당하지 않는다. */

    //다음은 오버로딩 성립 요건이 아니다.
//    public void test() {}
//    private void test() {}
//    public int test() {return 0;}

    public void test(int num) {}

    /* 매개변수 이름은 오버로딩과 무관하다. */
//    public void test(int num2) {}

    public void test(int num1, int num2) {}

    public void test(int num, String name) {}

    public void test(String name, int num) {} //파라미터의 순서가 변경되어도 오버로딩에 해당한다.
}

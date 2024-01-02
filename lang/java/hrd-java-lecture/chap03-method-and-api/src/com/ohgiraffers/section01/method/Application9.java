package com.ohgiraffers.section01.method;

public class Application9 {
    public static void main(String[] args) {
        /* 다른 클래스에 작성된 메소드를 호출할 수 있다. */
        int first = 100;
        int second = 500;

        /* 1. non-static 메소드 호출 */
        Calculator calculator = new Calculator();
        int min = calculator.minNumberOf(first, second);
        System.out.println("둘 중 최소 값은 ? " + min);

        /* 2. static 메소드 호출 */
        int max = Calculator.maxNumberOf(first, second);
        System.out.println("둘 중 최대 값은 ? " + max);

        /* 주의 사항
        * static 메소드도 non-static 메소드처럼 호출이 가능하지만 권장하지 않는다. */
        int max2 = calculator.minNumberOf(first, second);
        System.out.println("둘 중 최대 값은 ? " + max2);
    }
}

package com.ohgiraffers.section01.literal;

public class Application2 {
    public static void main(String[] args) {

        /* 값을 직접 연산하여 출력할 수 있다.
         * 이 때, 값의 형태에 따라 사용할 수 있는 연산자의 종류와 연산의 결과가 달라진다.
         */

        /* 1. 숫자의 연산 */
        System.out.println("===== 정수와 정수의 연산 =====");
        System.out.println(123 + 456);
        System.out.println(123 - 23);
        System.out.println(123 * 10);
        System.out.println(123 / 10); //정수와 정수를 나누면 정수로 값을 나온다.
        System.out.println(123 % 10);

        System.out.println("===== 실수와 실수의 연산 =====");
        System.out.println(1.23 + 1.23);
        System.out.println(1.23 - 0.23);
        System.out.println(1.23 * 10.0);
        System.out.println(1.23 / 10.0);
        System.out.println(1.23 % 1.0); //약간의 오차가 생긴다

        System.out.println("===== 정수와 실수의 연산 =====");
        System.out.println(123 + 0.5);
        System.out.println(123 - 0.5);
        System.out.println(123 * 0.5);
        System.out.println(123 / 0.5);
        System.out.println(123 % 0.5);

        /* 2. 문자의 연산 */
        System.out.println("===== 문자와 문자의 연산 =====");
        System.out.println('a' + 'b');
        System.out.println('a' - 'b');
        System.out.println('a' * 'b');
        System.out.println('a' / 'b');
        System.out.println('a' % 'b');

        System.out.println("===== 문자와 정수의 연산 =====");
        System.out.println('a' + 1);
        System.out.println('a' - 1);
        System.out.println('a' * 2);
        System.out.println('a' / 2);
        System.out.println('a' % 2);

        System.out.println("===== 문자와 실수의 연산 =====");
        System.out.println('a' + 1.0);
        System.out.println('a' - 1.0);
        System.out.println('a' * 2.0);
        System.out.println('a' / 2.0);
        System.out.println('a' % 2.0);

        /* 3. 문자열의 연산 */
        System.out.println("===== 문자열과 문자열의 연산 ====="); //더하기만 가능하다.
        System.out.println("hello" + "world");
        //System.out.println("hello" - "world"); //에러 발생
        //System.out.println("hello" * "world"); //에러 발생
        //System.out.println("hello" / "world"); //에러 발생
        //System.out.println("hello" % "world"); //에러 발생

        System.out.println("===== 문자열과 다른 형태의 값의 연산 =====");
        System.out.println("helloworld" + 123);
        System.out.println("helloworld" + 123.456);
        System.out.println("helloworld" + 'a');
        System.out.println("helloworld" + true);
        System.out.println("123" + "456");

        /* 4. 논리값 연산 */
        //논리 값은 내부적으로 숫자로 취급하지만 연산은 불가능하다. 단, 문자열과 '+' 연산은 가능하다.
        System.out.println(true + "a"); //문자열 합치기 됨

    }
}

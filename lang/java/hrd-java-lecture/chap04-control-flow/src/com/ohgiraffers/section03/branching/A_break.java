package com.ohgiraffers.section03.branching;

public class A_break {
    public void testSimpleBreakStatement() {
        /* break문 사용에 대한 흐름을 이해하고 적용할 수 있다. */

        /* break문을 이용하여 무한루프를 활용한 1~100까지의 합계 구하기 */
        int sum = 0;
        int i = 1;

        while (true) {
            sum += i++;
            if(i > 100){
                break;
            }
        }
        System.out.println("sum : " + sum);
    }

    public void testSimpleBreakStatement2() {
        /* 중첩 반복문 내 break문 사용에 대한 흐름을 이해하고 적용할 수 있다. */
        /* break는 모든 반복문을 종료하는 것이 아니라 자신에게 가장 인접한 반복문 실행만 멈춘다. */

        /* 구구단 2~9단을 출력하되 곱해지는 수가 5보다 큰 경우 출력하지 않는다. */
        for (int dan = 2; dan < 10; dan++) {
            for (int su = 1; su < 10; su++) {
                if(su > 5) {
                    break;
                }
                System.out.println(dan + " * " + su + " = " + (dan * su));
            }
        }
    }

    public void testJumpBreak() {
        /* 중첩 반복문 내 break문 사용 시 jump(goto)에 대한 흐름을 이해하고 적용할 수 있다. */
        label:
        for (;;) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i==3) {
                    break label;
                }
            }
        }
    }
}

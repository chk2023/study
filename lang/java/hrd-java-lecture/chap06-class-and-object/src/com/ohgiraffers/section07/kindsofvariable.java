package com.ohgiraffers.section07;

public class kindsofvariable {
    /* 다양한 변수를 이해하고 사용할 수 있다. */

    /* non-static field를 인스턴스 변수라고 한다. (인스턴스 생성 시점에 사용 가능한 변수) */
    private int globalNum;
    /* static field를 클래스 변수라고 한다. (정적 메모리 영역에 생성되는 변수) */

    private static int staticNum;

    public void method(int num) {   //매개 변수(일종의 지역 변수)
        int localNum; //지역 변수

        // 매개변수는 호출 시 값이 전달 되므로 별도의 초기화는 필요 없다.
        System.out.println("num : " + num);
        //지역 변수는 선언 외에 다시 사용하기 위해서는 반드시 초기화 되어야 한다.
//        System.out.println("localNum : " + localNum); //매개 변수와 달리 지역 변수는 반드시 초기화 해야 한다.

        System.out.println("globalNum : " + globalNum);
        System.out.println("staticNum : " + staticNum);
    }

    public void method2() {
        /* 지역 변수는 해당 지역(블럭 내)에서만 사용이 가능하며
        * 전역 변수는 클래스 내의 모든 영역에서 사용할 수 있다. */
//        System.out.println("localNum : " + localNum);
        System.out.println("globalNum : " + globalNum);
        System.out.println("staticNum : " + staticNum);
    }









}

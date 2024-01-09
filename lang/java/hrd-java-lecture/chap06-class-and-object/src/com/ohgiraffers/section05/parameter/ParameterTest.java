package com.ohgiraffers.section05.parameter;

import java.util.Arrays;

public class ParameterTest {

    public void testPrimaryTypeParameter(int num) {
        System.out.println("매개변수로 전달 받은 값 : " + num);
        num += 10;
        System.out.println("가공 된 num : " + num);
    }

    public void testPrimaryTypeParameter(int[] iarr) {
        System.out.println("매개변수로 전달 받은 값 : " + Arrays.toString(iarr));
        iarr[0] = 99;
        System.out.println("가공된 iarr : " + Arrays.toString(iarr));
    }

    public void testClassTypeParameter(Rectangle r) {
        System.out.println("매개변수로 전달 받은 넓이와 둘레");
        r.calcArea();
        r.calcRound();

        r.setWidth(100);
        r.setHeight(100);

        System.out.println("가공 된 넓이와 둘레");
        r.calcArea();
        r.calcRound();
    }

    public void testVariableLengthArrayParameter(String name, String... hobby) {
        /* 매개 변수가 몇 개 전달될 지 알 수 없으므로 반드시 매개변수 목록의 가장 뒤에 작성해야 한다. */
        System.out.println("이름 : " + name);
        System.out.println("취미의 개수 : " + hobby.length);
        System.out.println("취미 : " + Arrays.toString(hobby));
    }

    /* 가변 인자를 사용한 메소드를 오버로딩하면 모호해지는 문제가 발생할 수 있으므로 가급적 오버로딩 하지 않는다. */
//    public void testVariableLengthArrayParameter(String... hobby) {}
}

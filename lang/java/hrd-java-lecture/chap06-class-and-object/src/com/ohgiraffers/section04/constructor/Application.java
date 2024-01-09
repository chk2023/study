package com.ohgiraffers.section04.constructor;

import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        /* 생성자 함수가 무엇인지 이해하고 선언 및 호출할 수 있다. */

        /* 1. 기본 생성자 호출 */
        User user1 = new User();
        System.out.println(user1.getInformation());
        System.out.println("");

        /* 2. id, pwd, name을 매개변수로 전달 받는 생성자 호출 */
        User user2 = new User("user01", "pass01", "홍길동");
        System.out.println(user2.getInformation());
        System.out.println("");

        /* 3. 모든 필드를 초기화 하는 매개변수 생성자 호출 */
        /* java.util.Date 클래스의 기본 생성자를 통해 객체를 생성하면
        * 현재 프로그램이 동작하는 운영체제 상의 날짜/시간 정보를 이용해 인스턴스가 생성된다. */
        User user3 = new User("user02", "pass02", "유관순", new Date());
        System.out.println(user3.getInformation());
        System.out.println("");

    }
}

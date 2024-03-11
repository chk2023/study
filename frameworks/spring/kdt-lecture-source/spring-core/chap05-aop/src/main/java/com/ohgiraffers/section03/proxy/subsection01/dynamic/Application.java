package com.ohgiraffers.section03.proxy.subsection01.dynamic;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) {
        /* Proxy?
        * Target Object의 기능을 수행하면서 기능을 확장하거나 추가하는 실제 객체(대리인)
        * 프록시를 직접 만들 일은 잘 없지만, reflection 기능을 이용해 간단히 예제를 구현해 이해해본다.
        * */

        Student student = new OhgiraffersStudent();
        Handler handler = new Handler(student);

        /* 클래스로더, 프록시를 만들 클래스 메타 정보(인터페이스만), 프록시 동작 시 적용 될 핸들러 */
        Student proxy
                = (Student) Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[] { Student.class }, handler);

        /* 프록시로 감싸진 인스턴스의 메소드를 호출 => Handler 클래스의 invoke 메소드에 정의 된 메소드가 호출 된다. */
        proxy.study(16);

        /* 프록시 생성은 크게 두 가지 방식이 제공 된다.
        * 1. JDK Dynamic Proxy 방식
        * : Target Object의 타입이 반드시 interface여야 함
        * 2. CGLib 방식
        * : Target Object의 타입이 Class여도 사용 가능함. Dynamic Proxy 방식 보다 성능 향상.
        * */



    }
}

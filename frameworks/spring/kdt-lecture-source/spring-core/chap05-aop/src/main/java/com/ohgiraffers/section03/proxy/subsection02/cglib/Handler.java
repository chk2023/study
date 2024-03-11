package com.ohgiraffers.section03.proxy.subsection02.cglib;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/* reflect가 아닌 cglib 패키지에서 import */
public class Handler implements InvocationHandler {

    /* 인터페이스가 아닌 클래스 타입의 Target Object 사용 */
    private final OhgiraffersStudent ohgiraffersStudent;
    public Handler(OhgiraffersStudent ohgiraffersStudent) {
        this.ohgiraffersStudent = ohgiraffersStudent;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("===== 공부가 너무 하고 싶습니다. =====");
        System.out.println("호출 대상 메소드 : " + method);
        for(Object arg : args) {
            System.out.println("전달 된 인자 : " + arg);
        }

        /* 타겟 메소드를 호출 */
        method.invoke(ohgiraffersStudent, args);

        System.out.println("===== 공부를 마치고 수면 학습을 시작합니다. =====");

        return proxy;
    }
}

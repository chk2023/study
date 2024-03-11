package com.ohgiraffers.section03.proxy.subsection01.dynamic;

import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* 프록시에서 처리 할 메소드를 구현하기 위해 InvocationHandler를 implements */
public class Handler implements InvocationHandler {

    /* 메소드 호출을 위해 타겟 인스턴스가 필요 */
    private final Student student;
    public Handler(Student student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("===== 공부가 너무 하고 싶습니다. =====");
        System.out.println("호출 대상 메소드 : " + method);
        for(Object arg : args) {
            System.out.println("전달 된 인자 : " + arg);
        }

        /* 타겟 메소드를 호출 */
        method.invoke(student, args);

        System.out.println("===== 공부를 마치고 수면 학습을 시작합니다. =====");

        return proxy;
    }
}

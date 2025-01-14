package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
/* @Aspect : pointcut과 advice를 하나의 클래스 단위로 정의하기 위한 어노테이션 */
@Aspect
public class LoggingAspect {

    /* @Pointcut : 여러 조인 포인트를 매치하기 위해 지정한 표현식 */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut(){}

    /* JoinPoint : 포인트 컷으로 패치한 실행 시점
    * 이렇게 매치 된 조인 포인트에서 해야 할 일 => 어드바이스
    * JoinPoint 객체에는 현재 조인포인트의 메소드명, 인수 값 등 자세한 정보를 엑세스 할 수 있다. */
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0)
            System.out.println("Before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
    }

    /* 포인트 컷을 동일 클래스 내에서 사용한다면 클래스명을 생략할 수 있다.
    * 단, 패키지가 다르면 패키지를 포함한 클래스명을 기술해야 한다. */
    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0)
            System.out.println("After joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
    }

    /* returning 속성은 리턴 값으로 받아올 객체의 매개변수 이름과 동일해야 한다.
    * joinPoint는 반드시 첫 번째 매개변수로 선언해야 한다. */
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After Returning result : " + result);
        /* 리턴 결과 값 변형 */
        if(result != null && result instanceof Map) {
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환 값 가공"));
        }
    }

    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("After Throwing exception : " + exception);
    }

    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before " + joinPoint.getSignature().getName());
        /* 원본 조인포인트를 실행한다. */
        Object result = joinPoint.proceed();
        System.out.println("Around After " + joinPoint.getSignature().getName());
        /* 원본 조인포인트를 호출한 쪽 혹은 다른 어드바이스가 다시 실행할 수 있도록 반환한다. */
        return result;
    }


}


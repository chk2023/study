package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* @ControllerAdvice 어노테이션 적용 된 클래스의 @ExceptionHandler는 전역적으로 기능한다. */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception) {

        System.out.println("전역 범위의 Exception Handler");
        System.out.println("message: " + exception.getMessage());

        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException exception, Model model) {

        System.out.println("전역 범위의 Exception Handler");
        model.addAttribute("exception", exception);

        return "error/memberRegist";
    }

    /* 상위 타입의 Exception을 통해 Handler를 작성하면 하위 타입의 모든 Exception을 처리할 수 있다. */
    @ExceptionHandler(Exception.class)
    public String defaultException(Exception exception) {
        return "error/default";
    }









}

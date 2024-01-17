package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application03 {
    public static void main(String[] args) {
        /* multi catch block으로 동일한 레벨의 다른 타입의 예외를 하나의 catch 블럭으로 처리할 수 있다.
        * => 상위 타입의 Exception과 하위 타입의 Exception이 함께 서술될 수 없다.
        * Ex) Exception | NotEnoughMoneyException (x), NegativeException | PriceNegativeException (x)*/
        ExceptionTest et = new ExceptionTest();

        try {
            et.checkEnoughMoney(20000, -10000);
        } catch (PriceNegativeException | MoneyNegativeException e) {
            System.out.println(e.getClass() + "발생!"); //getClass()로 발생한 예외 클래스의 이름을 알 수 있음
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println("NotEnoughMoneyException 발생!");
            System.out.println(e.getMessage());
        }
    }
}

package com.ohgiraffers.section01;

public class Car extends Thread { //java.lang 패키지에 있어서 따로 import는 필요 없다.

    @java.lang.Override
    public void run() {
        /* Car 스레드로 수행할 작업 내용을 작성한다. */
        for (int i = 0; i < 1000; i++) {
            System.out.println("Car driving...");
            try {
                /* 현재 스레드를 지연시키는 메소드로 전달 인자로 밀리세컨을 전달한다. (1000분의 1초) */
                Thread.sleep(1); //1000분의 1초씩 기다렸다가 출력하는 행위를 반복.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package com.ohgiraffers.level02.normal;

public class Application2 {
    public static void main(String[] args) {
        double kor = 80.5;
        double math = 50.6;
        double eng = 70.8;

        System.out.println("총점 : " + (int)(kor+math+eng));
        System.out.println("평균 : " + (int)((kor+math+eng)/3));
    }
}

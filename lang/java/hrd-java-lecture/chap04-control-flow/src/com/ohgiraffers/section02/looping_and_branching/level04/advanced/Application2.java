package com.ohgiraffers.section02.looping_and_branching.level04.advanced;

import java.util.Scanner;

public class Application2 {
//    public static void main(String[] args) {
//
//        System.out.println("받으신 금액을 입력하세요 : ");
//        Scanner sc = new Scanner(System.in);
//        int bill = sc.nextInt();
//
//        System.out.println("상품 가격을 입력하세요 : ");
//        Scanner sc2 = new Scanner(System.in);
//        int price = sc2.nextInt();
//
//        int change = bill - price;
//
//        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
//        String[] names = {"50000원권", "10000원권", "5000원권", "1000원권", "500원권", "100원권", "50원권", "10원권"};
//
//        for (int i = 0; i < units.length; i++) {
//            double decimal = change / units[i];
//            System.out.println(names[i] + (int) (decimal));
//            change %= units[i];
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("받으신 금액을 입력하세요 : ");
        int money = sc.nextInt();

        System.out.print("상품 가격을 입력하세요 : ");
        int price = sc.nextInt();

        int change = money - price;
        int currency = 50000;
        int mok = 0;
        int nmg = 0;
        int sw = 0;
        int temp = change;

        System.out.println("=========================");
        while(true) {
            mok = temp / currency;
            nmg = temp % currency;

            if(mok == 0 && nmg == 0) {
                break;
            }

            if(mok != 0) {
                if(currency > 500)
                    System.out.println(currency + "원권 지폐 " + mok + "장");
                else
                    System.out.println(currency + "원권 동전 " + mok + "개");
            }

            if(sw == 0) { //반복하는 패턴이 /5, /2 이런식이니까 스위치를 도입. 스위치가 0일 때는 나누기 5, 그 후 1을 대입해서 스위치를 나누기 2.
                sw = 1;
                currency /= 5;
            } else {
                sw = 0;
                currency /= 2;
            }

            temp = nmg; //나머지를 담아서 다시 루프를 돌린다.
        }

        System.out.println("=========================");
        System.out.println("거스름돈 : " + change + "원");
    }
}


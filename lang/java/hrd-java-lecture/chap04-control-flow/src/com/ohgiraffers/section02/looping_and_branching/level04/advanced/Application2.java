package com.ohgiraffers.section02.looping_and_branching.level04.advanced;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        System.out.println("받으신 금액을 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        int bill = sc.nextInt();

        System.out.println("상품 가격을 입력하세요 : ");
        Scanner sc2 = new Scanner(System.in);
        int price = sc2.nextInt();

        int change = bill - price;

        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        String[] names = {"50000원권", "10000원권", "5000원권", "1000원권", "500원권", "100원권", "50원권", "10원권"};

        for (int i = 0; i < units.length; i++) {
            double decimal = change / units[i];
            System.out.println(names[i] + (int) (decimal));
            change %= units[i];
        }
    }
}

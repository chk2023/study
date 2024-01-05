package com.ohgiraffers.section02.looping_and_branching.level04.advanced;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("문자열을 입력하세요 : ");
        char userInput[] = sc.nextLine().toCharArray();

        System.out.println("숫자를 입력하세요 : ");
        int encoder = sc2.nextInt();

        char[] caesarCipher = new char[userInput.length];
        for (int i = 0; i < userInput.length; i++) {
            caesarCipher[i] = (char) (userInput[i] + encoder);
        }
        System.out.println(caesarCipher);
    }

// 27이상인 경우 1로 치환은 어떻게?
}

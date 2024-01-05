package com.ohgiraffers.section02.looping_and_branching.level03.hard;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("문자열 입력 : ");
        String userInput = sc.nextLine();

        for (int i = 0; i < userInput.length(); i++) {
            if (!(userInput.charAt(i) >= 'a' && userInput.charAt(i) <= 'z') && !(userInput.charAt(i) >= 'A' && userInput.charAt(i) <= 'Z')) {
                System.out.println("영문자가 아닌 문자가 포함되어 있습니다.");
                System.exit(0);
            }
        }

        System.out.println("문자 입력 : ");
        char userInput2 = sc2.next().charAt(0);

        int includedCharacter = 0;

        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == userInput2) {
                includedCharacter++;
            }
        }
        System.out.println("포함된 갯수 : " + includedCharacter);
    }
}

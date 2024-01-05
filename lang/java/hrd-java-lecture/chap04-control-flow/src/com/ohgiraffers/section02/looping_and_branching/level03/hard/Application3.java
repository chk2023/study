package com.ohgiraffers.section02.looping_and_branching.level03.hard;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("문자열 입력 : ");
        String userInput = sc.nextLine();

        for (int i = 0; i < userInput.length(); i++) {
            char temp = userInput.charAt(i);
            if (!(temp >= 'a' && temp <= 'z') && !(temp >= 'A' && temp <= 'Z')) {
                System.out.println("영문자가 아닌 문자가 포함되어 있습니다.");
                System.exit(0);  //또는 return문을 사용한다. return은 메소드의 종료를 의미한다.
            }
        }

        System.out.println("문자 입력 : ");
        char userInput2 = sc.next().charAt(0); //객체는 매번 참조 값이 달라지기 때문에 sc2 이런식으로 새로 만들지 않아도 된다.

        int includedCharacter = 0;

        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == userInput2) {
                includedCharacter++;
            }
        }
        System.out.println("포함된 갯수 : " + includedCharacter);
    }
}

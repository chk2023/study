package com.ohgiraffers.section02.looping_and_branching.level04.advanced;

import java.util.Scanner;

public class Application1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("문자열을 입력하세요 : ");
//        char userInput[] = sc.nextLine().toCharArray();
//
//        System.out.println("숫자를 입력하세요 : ");
//        int encoder = sc.nextInt();
//
//        char[] caesarCipher = new char[userInput.length];
//        for (int i = 0; i < userInput.length; i++) {
//            caesarCipher[i] = (char) (userInput[i] + encoder);
//        }
//        System.out.println(caesarCipher);
//    }
// 27이상인 경우 1로 치환은 어떻게?

    // 답안은 다음과 같다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("문자열을 입력하세요 : ");
        String s = sc.nextLine();

        System.out.println("숫자를 입력하세요 : ");
        int num = sc.nextInt();

        String result = "";
        int mod = num % 26;  //27이 넘는 경우 모드를 사용. 27 % 26 = 1.

        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i); //공백 문자를 제거한다.

            if(temp != ' ') {
                if(temp <= 'z' && temp >= 'a') {
                    if(temp + mod > 'z') {
                        result += (char) (temp + mod - 26); //z밖으로 간 경우 -26을 하여 다시 돌아오게 한다.
                    } else {
                        result += (char) (temp + mod);
                    }
                } else {
                    if(temp + mod > 'Z') {
                        result += (char) (temp + mod - 26); //Z밖으로 간 경우 -26을 하여 다시 돌아오게 한다.
                    } else {
                        result += (char) (temp + mod);
                    }
                }

            } else {
                result += temp;
            }

        }

        System.out.println(result);

    }
}

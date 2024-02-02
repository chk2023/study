package 코딩_기초_트레이닝;

import java.util.Scanner;

public class 문자열_출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int a = str.length();
        if(1<=a&&a<=1000000){
            System.out.println(str);
        }
    }
}
package 코딩_기초_트레이닝;

import java.util.Scanner;

public class 문자열_돌리기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        for(int i=0; i<a.length(); i++){
            char chr = a.charAt(i);
            System.out.println(chr);
        }
    }
}
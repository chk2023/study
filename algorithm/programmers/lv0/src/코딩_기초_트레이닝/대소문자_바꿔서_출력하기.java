package 코딩_기초_트레이닝;

import java.util.Scanner;

public class 대소문자_바꿔서_출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String answer = "";
        for (int i=0; i<str.length(); i++){
            char chr = str.charAt(i);

            if (65<=chr && chr<=90){
                answer += String.valueOf(chr).toLowerCase();
            }else{
                answer += String.valueOf(chr).toUpperCase();
            }
        }
        System.out.println(answer);
    }
}
        
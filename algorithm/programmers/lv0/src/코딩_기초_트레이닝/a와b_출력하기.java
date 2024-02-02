package 코딩_기초_트레이닝;

import java.util.Scanner;

public class a와b_출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if((-100000 <= a && a<= 100000)&&(-100000 <=b && b<= 100000)){
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }
    }
}
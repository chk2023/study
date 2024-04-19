package datastructure.arrayandlist;

import java.util.Scanner;

public class P11720_숫자의_합_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        char[] charNum = num.toCharArray();
        int sum = 0;

        for (int i = 0; i < charNum.length; i++) {
            sum += charNum[i] - '0';
        }

        System.out.println(sum);
    }
}

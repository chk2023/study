import java.util.Scanner;

public class 문자열_반복해서_출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        int a = str.length();

        if((1<=a && a<=10)&&(1<=n && n<=5)){
            for(int i=0; i<n; i++){
                System.out.print(str);
            }
        }
    }
}
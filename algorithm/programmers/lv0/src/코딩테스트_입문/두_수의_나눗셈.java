package 코딩테스트_입문;

public class 두_수의_나눗셈 {
    /* 정수 num1과 num2가 매개변수로 주어질 때,
    * num1을 num2로 나눈 값에 1,000을 곱한 후 정수 부분을 return 하도록 soltuion 함수를 완성해주세요.
    * */
    public int solution(int num1, int num2) {
        int answer = (int)(((double)num1 / num2) * 1000);
        return answer;
    }
}

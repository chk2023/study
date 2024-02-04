package 코딩테스트_입문;

public class 배열의_평균값 {
    /* 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소의 평균값을 return하도록 solution 함수를 완성해주세요. */
    public double solution(int[] numbers) {
        double answer = 0;
        double sum = 0;
        for (int num : numbers) {
            sum += num;
            answer = sum/numbers.length;
        }
        return answer;
    }
}

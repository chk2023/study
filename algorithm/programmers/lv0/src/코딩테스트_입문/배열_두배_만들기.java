package 코딩테스트_입문;

public class 배열_두배_만들기 {
    /* 정수 배열 numbers가 매개변수로 주어집니다.
    * numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록 solution 함수를 완성해주세요. */
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                answer[i] = numbers[i] *2;
            }
            return answer;
        }
    }
}

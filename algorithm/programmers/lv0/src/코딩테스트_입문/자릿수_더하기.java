package 코딩테스트_입문;

public class 자릿수_더하기 {
    /* 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요 */
    class Solution {
        public int solution(int n) {
            int answer = 0;

            String number = Integer.toString(n);

            for (int i = 0; i < number.length(); i++) {
                answer += Character.getNumericValue(number.charAt(i));
            }
            return answer;
        }
    }

    /* 오답노트 */
    /* 문자를 숫자로 바꾸는 메서드는 Character.getNumericValue()이다. */
}

package 코딩테스트_입문;

public class 숨어있는_숫자의_덧셈1 {
    /* 문자열 my_string이 매개변수로 주어집니다.
    * my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요. */
    class Solution {
        public int solution(String my_string) {
            int answer = 0;

            String number = my_string.replaceAll("[a-zA-Z]", "");

            for (int i = 0; i < number.length(); i++) {
                answer += Character.getNumericValue(number.charAt(i));
            }
            return answer;
        }
    }

    /* 오답노트 */
    /* [a-zA-Z]는 대소문자 영어 알파벳을 찾는 정규 표현식이다.
    * my_string에서 영문자와 숫자를 솎아내야 할 때 필요 없는 영문자는 없애줄 수 있다고 유연하게 사고하기. */
}

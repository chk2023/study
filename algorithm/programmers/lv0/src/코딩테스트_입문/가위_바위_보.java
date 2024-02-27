package 코딩테스트_입문;

public class 가위_바위_보 {
    /* 가위는 2 바위는 0 보는 5로 표현합니다. 가위 바위 보를 내는 순서대로 나타낸 문자열 rsp가 매개변수로 주어질 때,
    * rsp에 저장된 가위 바위 보를 모두 이기는 경우를 순서대로 나타낸 문자열을 return하도록 solution 함수를 완성해보세요. */
    class Solution {
        public String solution(String rsp) {
            String answer = "";

            for (int i = 0; i < rsp.length(); i++) {
                if (rsp.charAt(i) == '2') {
                    answer += "0";
                } else if (rsp.charAt(i) == '0') {
                    answer +=  "5";
                } else if (rsp.charAt(i) == '5') {
                    answer +=  "2";
                }
            }
            return answer;
        }
    }
    /* 오답노트 */
    /* 그냥 각 숫자를 대입하면 되는 걸 복잡하게 연산했었다.
    * 문자열을 문자로, 문자를 또 숫자로 바꿔 연산하는 것은 미련한 짓이다. */

}

package 코딩_기초_트레이닝;

public class 공백으로_구분하기1 {
    /* 단어가 공백 한 개로 구분되어 있는 문자열 my_string이 매개변수로 주어질 때,
    * my_string에 나온 단어를 앞에서부터 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.*/
    class Solution {
        public String[] solution(String my_string) {
            String[] answer = {};
            answer = my_string.split(" ");
            return answer;
        }
    }
    /* 오답노트 */
    /* 배열 생성 시 꼭 사이즈를 선언하지 않아도 된다. */
}

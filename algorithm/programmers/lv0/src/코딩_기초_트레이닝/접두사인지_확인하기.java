package 코딩_기초_트레이닝;

public class 접두사인지_확인하기 {
    /* 어떤 문자열에 대해서 접두사는 특정 인덱스까지의 문자열을 의미합니다.
    * 예를 들어, "banana"의 모든 접두사는 "b", "ba", "ban", "bana", "banan", "banana"입니다.
    * 문자열 my_string과 is_prefix가 주어질 때, is_prefix가 my_string의 접두사라면 1을,
    * 아니면 0을 return 하는 solution 함수를 작성해 주세요. */

    class Solution {
        public int solution(String my_string, String is_prefix) {
            int answer = 0;

            String arr[] = new String[my_string.length()];

            for (int i = 0; i < my_string.length(); i++) {
                arr[i] = my_string.substring(0, i);

                if (is_prefix.equals(arr[i])) {
                    answer = 1;
                    break;
                } else {
                    answer = 0;
                }
            }
            return answer;
        }
    }

    /* 오답노트 */
    /* 조건문에서 is_prefix == arr[i]라고 했다.
    * 이는 동일한 객체인지 비교하기 때문에 틀린 답이다.
    * 문자열끼리 비교할 때는 equals() 메서드를 사용하자.*/

}

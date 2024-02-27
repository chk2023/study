package 코딩_기초_트레이닝;

public class 접미사인지_확인하기 {
    /* 어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다.
    * 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
    * 문자열 my_string과 is_suffix가 주어질 때, is_suffix가 my_string의 접미사라면 1을,
    * 아니면 0을 return 하는 solution 함수를 작성해 주세요. */
    class Solution {
        public int solution(String my_string, String is_suffix) {
            int answer = 0;
            String arr[] = new String[my_string.length()];

            for (int i = my_string.length() - 1, j = 0; i >= 0; i--) {
                arr[j++] = my_string.substring(i);
            }

            for (int k = 0; k < arr.length; k++) {
                if (is_suffix.equals(arr[k])) {
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
    /* substirng() 메서드에 인자로 i만 전달해도 알아서 감소하면서 뒤에 부터 잘라준다. */
}

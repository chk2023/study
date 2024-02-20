package 코딩테스트_입문;

public class 모음_제거 {
    /* 영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다.
    문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요. */
    class Solution {
        public String solution(String my_string) {
            String answer = my_string;
            String[] vowels = {"a", "e", "i", "o", "u"};
            for (String v : vowels) {
                answer = answer.replaceAll(v, "");
            }
            return answer;
        }
    }

    /* 오답 노트 */
    class Incorrect {
        public String solution(String my_string) {
            String answer = "";

            String vowels[] = {"a", "e", "i", "o", "u"};

            for (String v : vowels) {
                answer = my_string.replaceAll(v, "");
            }
            return answer;
        }
    }
    /* 자바에서 문자열은 불변이다.
    * 한 번 생성된 문자열은 변경할 수 없다.
    * 따라서 문자열에 대한 어떤 연산이든지(replaceAll, substring, toLowerCase 등) 항상 새로운 문자열을 생성한다.
    * 위에서 answer는 반복문이 돌 때마다 새로운 문자열을 참조하게 된다.
    * 해결 방법은 다음과 같다.*/

    class Solution2 {
        public String solution(String my_string) {
            String answer = my_string;

            String vowels[] = {"a", "e", "i", "o", "u"};

            for (String v : vowels) {
                answer = answer.replaceAll(v, "");
            }
            return answer;
        }
    }

    /* 이렇게 해주면 answer에는 수정된 문자열이 대입되면서 원하는 대로 명령을 완수한다. */

}





















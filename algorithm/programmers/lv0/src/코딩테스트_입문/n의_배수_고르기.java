package 코딩테스트_입문;

public class n의_배수_고르기 {
    /* 정수 n과 정수 배열 numlist가 매개변수로 주어질 때,
    numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요. */
    class Solution {
        public int[] solution(int n, int[] numlist) {
            int count = 0;

            for (int i = 0; i < numlist.length; i++) {
                if (numlist[i] %n == 0) {
                    count ++;
                }
            }

            int [] answer = new int[count];

            for (int i = 0, j = 0; i < numlist.length; i++){
                if (numlist[i] %n == 0) {
                    answer[j++] = numlist[i];
                }
            }
            return answer;
        }
    }

    /* 오답노트 */
    class IncorrectSolution {
        public int[] solution(int n, int[] numlist) {
            int count = 0;

            for (int i = 0; i < numlist.length; i++) {
                if (numlist[i] %n == 0) {
                    count ++;
                }
            }

            int [] answer = new int[count];

            for (int i = 0, j = 0; i < numlist.length; i++, j++){
                if (numlist[i] %n == 0) {
                    answer[j] = numlist[i];
                }
            }
            return answer;
        }
    }
    /* 위 처럼 j를 i와 같이 증가시키면 j의 0번째 인덱스에 값을 넣어야 하는데 넣을 수가 없다.
    * 같이 증가했기 때문이다. */
}

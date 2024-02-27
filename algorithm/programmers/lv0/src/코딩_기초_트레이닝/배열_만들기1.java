package 코딩_기초_트레이닝;

public class 배열_만들기1 {
    /* 정수 n과 k가 주어졌을 때, 1 이상 n이하의 정수 중에서 k의 배수를
    * 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요. */
    class Solution {
        public int[] solution(int n, int k) {
            int[] answer = new int[n/k];

            for (int i = k, j = 0; i <= n; i += k, j++) {
                answer[j] = i;
            }

            return answer;
        }
    }

    /* 오답노트 */
    /* 반복문에서 i += i 라고 하는 경우 매 반복마다 수가 두 배로 커진다.
    * 하지만 문제에서 요구하는 것은 배수만큼 커지는 것. */
}

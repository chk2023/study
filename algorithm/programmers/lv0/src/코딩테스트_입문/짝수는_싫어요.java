package 코딩테스트_입문;

public class 짝수는_싫어요 {
    /* 정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요. */
    class Solution {
        public int[] solution(int n) {
            int[] answer = new int[(int) Math.ceil(n/2.0)];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = i * 2 + 1;
            }
            return answer;
        }
    }

    /* 오답노트 */
    /* (int) Math.ceil(n/2.0)
    * n/2를 하면 정수가 되므로 Math.ceil을 해도 올림이 의미가 없어진다.
    * 또한 Math.ceil을 한 결과는 소수이기 때문에 형변환을 해준다.
    *
    * answer[i] = n보다 작은 모든 홀수를 대입하는 방법이 떠오르지 않았다.
    * 항상 주어진 조건들을 사용해야 한다. */
}

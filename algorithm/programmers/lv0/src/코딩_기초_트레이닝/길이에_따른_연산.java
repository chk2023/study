package 코딩_기초_트레이닝;

public class 길이에_따른_연산 {
    /* 정수가 담긴 리스트 num_list가 주어질 때,
    * 리스트의 길이가 11 이상이면 리스트에 있는 모든 원소의 합을 10 이하이면 모든 원소의 곱을 return하도록
    * solution 함수를 완성해주세요. */
    class Solution {
        public int solution(int[] num_list) {
            int answer = (num_list.length >= 11) ? 0 : 1;

            for (int i = 0; i < num_list.length; i++) {
                if (num_list.length >= 11) {
                    answer += num_list[i];
                } else {
                    answer *= num_list[i];
                }
            }
            return answer;
        }
    }

    /* 오답노트 */
    /* if 조건식에서 answer가 0이어야 하는 경우가 있고 1로 시작해야 하는 경우가 있다면 위처럼 answer 값을 초기화한다. */
}

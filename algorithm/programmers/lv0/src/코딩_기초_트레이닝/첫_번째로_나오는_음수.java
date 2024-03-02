package 코딩_기초_트레이닝;

public class 첫_번째로_나오는_음수 {
    /* 정수 리스트 num_list가 주어질 때,
     * 첫 번째로 나오는 음수의 인덱스를 return하도록 solution 함수를 완성해주세요. 음수가 없다면 -1을 return합니다. */
    class Solution {
        public int solution(int[] num_list) {
            int answer = -1;

            for (int i = 0; i < num_list.length; i++) {
                if (num_list[i] < 0) {
                    answer = i;
                    break;
                }
            }
            return answer;
        }
    }
    /* 오답노트 */
    /* 처음에 else-if문을 통해 음수가 아닌 경우의 인덱스를 출력하도록 했다.
    * 하지만 모든 인덱스는 음수가 아니기에 결과 값이 모두 -1이 되는 문제가 생겼다.
    * 따라서 애초에 answer에 기본값을 -1로 설정하여 if문 조건에 부합하지 않는 경우
    * -1을 출력하도록 했다. */
}



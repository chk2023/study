package 코딩_기초_트레이닝;

public class 정수_찾기 {
    /* 정수 리스트 num_list와 찾으려는 정수 n이 주어질 때,
    * num_list안에 n이 있으면 1을 없으면 0을 return하도록 solution 함수를 완성해주세요. */
    class Solution {
        public int solution(int[] num_list, int n) {
            int answer = 0;

            for (int i = 0; i < num_list.length; i++) {
                if (num_list[i] == n) {
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
    /* 위 코드에서 break문이 없는 경우 배열을 순회하면서 마지막 인덱스의 값이 없으면 값은 무조건 answer는 0이된다. */
}

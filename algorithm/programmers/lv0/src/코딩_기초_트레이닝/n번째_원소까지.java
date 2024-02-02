package 코딩_기초_트레이닝;

public class n번째_원소까지 {
    /* 정수 리스트 num_list와 정수 n이 주어질 때,
    * num_list의 첫 번째 원소부터 n 번째 원소까지의 모든 원소를 담은 리스트를 return하도록 solution 함수를 완성해주세요.
    * */

    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] += num_list[i];
        }
        return answer;
    }
}

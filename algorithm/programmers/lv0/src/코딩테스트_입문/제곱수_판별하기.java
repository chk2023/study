package 코딩테스트_입문;

public class 제곱수_판별하기 {
    /* 어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다.
     * 정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요. */
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int root = (int) Math.sqrt(n);

            if (n % root == 0) {
                answer = 1;
            } else {
                answer = 2;
            }
            return answer;
        }
    }
}

package 코딩테스트_입문;

public class 순서쌍의_개수 {
    /* 순서쌍이란 두 개의 숫자를 순서를 정하여 짝지어 나타낸 쌍으로 (a, b)로 표기합니다.
    * 자연수 n이 매개변수로 주어질 때 두 숫자의 곱이 n인 자연수 순서쌍의 개수를 return하도록 solution 함수를 완성해주세요 */
    class Solution {
        public int solution(int n) {
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    answer ++;
                }
            }
            return answer;
        }
    }
    
    /* 오답노트 */
    /* 두 숫자의 곱이 n인 자연수 순서쌍의 개수는 n의 약수의 개수다.
    * n의 약수는 1부터 n까지 자기 자신으로 나누어 0이 나오는 숫자. */
}

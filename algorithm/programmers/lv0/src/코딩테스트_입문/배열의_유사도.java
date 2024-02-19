package 코딩테스트_입문;

public class 배열의_유사도 {
    /* 두 배열이 얼마나 유사한지 확인해보려고 합니다.
     * 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 return하도록 solution 함수를 완성해주세요 */

    public int solution(String[] s1, String[] s2) {
        int answer = 0;

        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if (s1[i] == s2[j]) {
                    answer++;
                }
            }
        }
        return answer;
    }

    /* 오답노트 */
    /* 자바에서 문자열끼리 비교할 때는 equals() 메서드를 사용해야 한다. */
    class Solution {
        public int solution(String[] s1, String[] s2) {
            int answer = 0;

            for (int i = 0; i < s1.length; i++) {
                for (int j = 0; j < s2.length; j++) {
                    if (s1[i].equals(s2[j])) {
                        answer++;
                    }
                }
            }
            return answer;
        }
    }
}


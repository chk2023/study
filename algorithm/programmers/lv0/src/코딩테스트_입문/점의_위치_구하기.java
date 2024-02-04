package 코딩테스트_입문;

public class 점의_위치_구하기 {
    /* 사분면은 한 평면을 x축과 y축을 기준으로 나눈 네 부분입니다. 사분면은 아래와 같이 1부터 4까지 번호를매깁니다. */
    public int solution(int[] dot) {
        int answer = 0;
        if (dot[0] > 0) {
            if (dot[1] > 0) {
                answer = 1;
            } else {
                answer = 4;
            }
        } else {
            if (dot[1] > 0) {
                answer = 2;
            } else {
                answer = 3;
            }
        }
        return answer;
    }
}

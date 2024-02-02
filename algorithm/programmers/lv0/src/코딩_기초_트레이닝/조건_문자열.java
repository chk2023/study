package 코딩_기초_트레이닝;

public class 조건_문자열 {
    public int solution(String ineq, String eq, int n, int m) {
        if ("<".equals(ineq)) {
            if ("=".equals(eq)) {
                return n <= m ? 1 : 0;
            } else if ("!".equals(eq)) {
                return n < m ? 1 : 0;
            }
        } else if (">".equals(ineq)) {
            if ("=".equals(eq)) {
                return n >= m ? 1 : 0;
            } else if ("!".equals(eq)) {
                return n > m ? 1 : 0;
            }
        }
        return -1; //모든 조건을 검사한 후에도 반환 값이 없는 경우가 있으므로 -1 반환.
    }
}

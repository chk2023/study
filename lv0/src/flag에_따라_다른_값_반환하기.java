public class flag에_따라_다른_값_반환하기 {
    public int solution(int a, int b, boolean flag) {

        if (flag == true) {
            return a + b;
        } else {
            return a -b;
        }
    }
}

class 두_수의_연산값_비교하기 {
    public int solution(int a, int b) {

        int result = 2 * a * b;
        int result2 = Integer.parseInt("" + a + b);

        if (result>result2) {
            return result;
        } else if (result<result2) {
            return result2;
        } else {
            return result;
        }
    }
}
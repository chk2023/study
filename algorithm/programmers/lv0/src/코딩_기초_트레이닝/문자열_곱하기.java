package 코딩_기초_트레이닝;

public class 문자열_곱하기 {
    public String solution(String my_string, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(my_string);
        }
        return sb.toString();
    }
}

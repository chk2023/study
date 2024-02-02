package 코딩_기초_트레이닝;

public class 문자_리스트를_문자열로_변환하기 {
    public String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}

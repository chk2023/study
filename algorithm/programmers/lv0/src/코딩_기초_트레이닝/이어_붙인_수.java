package 코딩_기초_트레이닝;

public class 이어_붙인_수 {
    public int solution(int[] num_list) {
        String even_number = "";
        String odd_number = "";

        for (int num : num_list) {
            if (num % 2 == 0) {
                even_number += Integer.toString(num);
            } else {
                odd_number += Integer.toString(num);
            }
        }
        int answer = Integer.parseInt(even_number) + Integer.parseInt(odd_number);
        return answer;
    }
}

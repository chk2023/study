package 코딩_기초_트레이닝;

public class 더_크게_합치기 {
    public int solution(int a, int b) {

        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        String sumStr = str1 + str2;
        String sumStr2 = str2 + str1;

        int sum = Integer.parseInt(sumStr);
        int sum2 = Integer.parseInt(sumStr2);

        if (sum > sum2) {
            return sum;
        } else if (sum < sum2) {
            return sum2;
        } else {
            // 여기서 적절한 값을 반환해야 합니다.
            // 만약 두 값이 동일하다면 어느 것을 반환해도 괜찮으니,
            // 이 경우에는 그냥 'sum'을 반환하겠습니다.
            return sum;
        }
    }
}


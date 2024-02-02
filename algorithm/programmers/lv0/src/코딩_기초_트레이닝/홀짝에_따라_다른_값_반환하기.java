package 코딩_기초_트레이닝;

public class 홀짝에_따라_다른_값_반환하기 {
    public int solution(int n) {
        int sumOdd = 0; //메서드 밖에서 꼭 선언해주어야 한다.
        int sumEven = 0;

        if (n%2!=0){
            for (int i=1; i<=n; i+=2){
                sumOdd += i;
            }
            return sumOdd; //return 문은 반복문 밖에 있어야 한다. 아니면 반복문이 1회 실행 후 종료.
        } else {
            for (int j=0; j<=n; j+=2){
                sumEven += j*j;
            }
        }
        return sumEven;
    }
}

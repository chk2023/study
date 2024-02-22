package 코딩_기초_트레이닝;

public class n보다_커질_때까지_더하기 {
    /* 정수 배열 numbers와 정수 n이 매개변수로 주어집니다.
    * numbers의 원소를 앞에서부터 하나씩 더하다가 그 합이 n보다 커지는 순간
    * 이때까지 더했던 원소들의 합을 return 하는 solution 함수를 작성해 주세요. */
    class Solution {
        public int solution(int[] numbers, int n) {
            int answer = 0;
            int result = 0;

            for (int i = 0; i < numbers.length; i++) {
                result += numbers[i];
                if (result > n) {
                    answer = result;
                    break;
                }
            }
            return answer;
        }
    }

    /* 오답노트 */
    class IncorrectAnswer {
        public int solution(int[] numbers, int n) {
            int answer = 0;
            int result = numbers[0];

            for (int i = 1; i < numbers.length; i++) {
                result += numbers[i];
                if (result > n) {
                    answer = result;
                    break;
                }
            }
            return answer;
        }
    }
    /* result가 numbers[0]으로 초기화되면
    * numbers[1]을 더하기 전에 numbers[0]이 n보다 큰 경우가 있다.
    * 하지만 코드는 무조건 numbers[1]을 한 번 더해주기 때문에
    * 잘못된 값을 반환하는 것. */
}

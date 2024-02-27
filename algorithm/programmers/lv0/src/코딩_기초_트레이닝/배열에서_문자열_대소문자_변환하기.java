package 코딩_기초_트레이닝;

public class 배열에서_문자열_대소문자_변환하기 {
    /* 문자열 배열 strArr가 주어집니다. 모든 원소가 알파벳으로만 이루어져 있을 때, 배열에서 홀수번째 인덱스의 문자열은 모든 문자를 대문자로,
    * 짝수번째 인덱스의 문자열은 모든 문자를 소문자로 바꿔서 반환하는 solution 함수를 완성해 주세요. */
    class Solution {
        public String[] solution(String[] strArr) {
            String[] answer = new String[strArr.length];

            for (int i = 0, j = 0; i < strArr.length; i++, j++) {
                if (i %2 == 0 || i == 0) {
                    answer[j] = strArr[i].toLowerCase();
                } else {
                    answer[j] = strArr[i].toUpperCase();
                }
            }
            return answer;
        }
    }
}

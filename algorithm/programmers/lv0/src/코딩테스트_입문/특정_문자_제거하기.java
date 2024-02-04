package 코딩테스트_입문;

public class 특정_문자_제거하기 {
    /* 문자열 my_string과 문자 letter이 매개변수로 주어집니다.
    * my_string에서 letter를 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
    * */
    public String solution(String my_string, String letter) {
        String answer = my_string.replace(letter, "");
        return answer;
    }
}

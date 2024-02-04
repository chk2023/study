package 코딩테스트_입문;

public class 배열_뒤집기 {
    /* 정수가 들어 있는 배열 num_list가 매개변수로 주어집니다.
    * num_list의 원소의 순서를 거꾸로 뒤집은 배열을 return하도록 solution 함수를 완성해주세요.
    */
    public int[] solution(int[] num_list) {
        int[] array = new int[num_list.length];
        int num = 0;

        for (int i = num_list.length-1; i >= 0; i--) {
            array[num] = num_list[i];
            num++;
        }
        return array;
    }

    /* 더 나은 풀이 */
    public int[] solution2(int[] num_list) {
        int[] array = new int[num_list.length];

        for (int i = 0; i < num_list.length; i++) {
            array[i] = num_list[num_list.length-1-i];
        }
        return array;
    }
}



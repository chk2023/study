public class 수_조작하기1 {
    public int solution(int n, String control) {
        for(char c : control.toCharArray()){
            switch (c) {
                case 'w':
                    n+=1;
                    break;
                case 's':
                    n-=1;
                    break;
                case 'd':
                    n+=10;
                    break;
                case 'a':
                    n-=10;
                    break;
            }
        }
        return n;
    }
}

/* 자바에서 문자열은 내부적으로 문자의 배열로 관리한다.
 * toCharArray() 메소드를 사용하면 문자열에 포함된 각 문자들을 원소로 하는 배열을 얻을 수 있습니다.
 * for (char c : control.toCharArray())는 control 문자열의 각 문자를 처음부터 끝까지 순회하며,
 * 각 문자를 c라는 변수에 할당하는 구문입니다.
 * 이렇게 하면 반복문 내에서 c를 통해 현재 순회 중인 문자에 접근할 수 있습니다.
 * 예를 들어, control이 "wasd"라면, 반복문은 네 번 실행되며, 각 실행마다 c는 순서대로 'w', 'a', 's', 'd' 값을 가지게 됩니다.
 * 이를 이용해 각 문자에 대한 처리를 진행할 수 있습니다.
 * 즉, 위의 코드는 control 문자열에 포함된 각 문자에 대해 반복을 수행하며, 각 반복에서 현재 문자를 c라는 변수에 저장하는 의미를 가집니다.
 */

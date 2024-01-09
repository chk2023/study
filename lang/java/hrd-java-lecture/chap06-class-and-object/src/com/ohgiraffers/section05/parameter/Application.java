package com.ohgiraffers.section05.parameter;

import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        /* 메소드의 파라미터에 대해 이해하고 사용할 수 있다. */

        /* 매개변수로 사용 가능한 자료형
         * 1. 기본 자료형
         * 2. 기본 자료형 배열
         * 3. 클래스 자료형
         * 4. 클래스 자료형 배열
         * 5. 가변 인자
         * */

        ParameterTest pt = new ParameterTest();

        /* 1. 기본 자료형을 매개변수로 전달 (기본 자료형 8가지 모두 가능) */
        int num = 20;
        pt.testPrimaryTypeParameter(num);

        /* 기본 자료형은 "값을 전달"하므로 메소드 내에서 변경 시켜도 main에서의 변수는 변화가 없다. */
        System.out.println("main num : " + num); //스택 영역에서 test 메소드가 호출된 이후 해당 공간은 사라지기 때문에 20 출력.

        /* 2. 기본 자료형 배열 */
        int[] iarr = {1, 2, 3, 4, 5};
        pt.testPrimaryTypeParameter(iarr);

        /* 배열은 "주소 값을 전달"하므로 얕은 복사가 일어나 동일한 배열을 다루고 있다.
        * 따라서 값의 변화가 그대로 출력 된다. */
        System.out.println("main iarr : " + Arrays.toString(iarr)); //이번에는 값이 바뀜.

        /* 3. 클래스 자료형 */
        Rectangle r = new Rectangle(12.5, 22.5);
        pt.testClassTypeParameter(r);

        /* 클래스 자료형은 "주소 값을 전달"하므로 얕은 복사가 일어나 동일한 객체를 다루고 있다. */
        System.out.println("main의 넓이와 둘레");
        r.calcArea();
        r.calcRound();
        
        /* 5. 가변 인자 
        * 인자로 전달하는 값의 갯수가 정해지지 않은 경우 가변 인자를 활용할 수 있다. */
//        pt.testVariableLengthArrayParameter(); //name은 반드시 전달 되어야 함
        pt.testVariableLengthArrayParameter("홍길동");
        pt.testVariableLengthArrayParameter("홍길동", "볼링");
        pt.testVariableLengthArrayParameter("홍길동", "볼링", "축구", "테니스");
        pt.testVariableLengthArrayParameter("홍길동", new String[]{"볼링", "축구", "테니스"});
        

    }
}

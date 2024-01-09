package com.ohgiraffers.section06.final_keyword;

public class FinalFieldTest {
    /* final 키워드를 사용할 수 있는 위치는 다양하다.
    * 의미는 약간은 다르지만 변경 불가의 의미를 가진다.
    * 1. 지역 변수 : 초기화 이후 값 변경 불가
    * 2. 매개 변수 : 호출 시 전달한 인자 변경 불가
    * 3. 인스턴스 변수 : 인스턴스 생성 후 초기화 이후에 값 변경 불가
    * 4. 클래스 변수(static) : 프로그램 시작 이후 값 변경 불가
    * 5. non-static 메소드 : 메소드 재작성(overriding) 불가
    * 6. static 메소드 : 메소드 재작성(overriding) 불가
    * 7. 클래스 : 상속 불가
    * */

    /* non-static 필드에 final 사용
    * 초기 인스턴스 생성 시 기본 값 0이 필드에 들아가게 되는데 초기화 이후 값 변경이 불가능하므로
    * 선언과 동시에 초기화를 해주어야 한다. 그렇지 않으면 compile error가 발생한다. */
//    private final int nonStaticNum; //final을 붙이기 전 값을 초기화해야 한다. 한 번 붙이면 변경할 수 없는데 왜 초기화 하지 않았냐는 의미다.

    /* 선언과 동시에 초기화 */
    private final int NON_STATIC_NUM = 1;

    /* 생성자를 이용해서 초기화 */
    //생성자를 통해 초기화하면 그때마다 인자를 전달해서 값을 바꿀 수 있다.
    private final String NON_STATIC_NAME;

    public FinalFieldTest(String nonStaticName) {
        this.NON_STATIC_NAME = nonStaticName;
    }

    /* static field에 final 키워드 사용 */
//    private static final int STATIC_NUM; //키워드 순서는 상관없다. 보통 static final이라고 많이 적는다.

    /* 선언과 동시에 초기화 */
    private static final int STATIC_NUM = 1;

    /* 생성자를 이용한 초기화는 불가능하다.
    * 생성자는 인스턴스 생성 시점에 호출 되고, static은 프로그램이 시작될 때 할당되므로
    * 초기화 되지 않은 상태로 선언된 것과 동일하다. */

    private static final double STATIC_DOUBLE;

    /* 초기화 블럭을 통해 초기화 할 수 있다. */
    static {
        STATIC_DOUBLE = 0.5;
    }

    /* public static final을 상수 필드라고 칭한다. */
//    Math.PI;





}

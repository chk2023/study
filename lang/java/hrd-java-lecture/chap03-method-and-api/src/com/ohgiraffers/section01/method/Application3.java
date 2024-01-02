package com.ohgiraffers.section01.method;

public class Application3 {
    public static void main(String[] args) {
        /* 메소드 전달 인자(argument)와 매개변수(parameter)에 대해 이해하고 메소드 호출 시 사용할 수 있다.*/
        Application3 app3 = new Application3();
        app3.testMethod(40);
        app3.testMethod(30);
        //app.testMethod("40"); //매개변수는 int형이지만 인자가 String 형이기 때문에 호출할 수 없다.
        //app.testMethod(20, 30, 40); //매개변수는 int형 1개 이지만 인자는 3개이기 때문에 호출할 수 없다.
        //app.testMethod(); //매개변수는 선언되어 있지만 인자로 값을 전달하지 않으면 호출할 수 없다.


        /* 2. 변수에 저장한 값 전달 테스트 */
        int age = 20;
        app3.testMethod(age); //리터럴 값을 직접 전달할 수도 있지만 변수로 보낼 수도 있다.

        /* 3. 자동 형변환을 이용한 값 전달 테스트 */
        byte byteAge = 10;
        app3.testMethod(byteAge); //매개변수는 int이지만 전달 되면서 자동 형변환 되었다.

        /* 4. 강제 형변환을 이용한 값 전달 테스트 */
        long longAge = 80;
        app3.testMethod((int)longAge); //강제 형변환을 해주지 않으면 컴파일 에러

        /* 5. 연산 결과를 이용한 값 전달 테스트 */
        app3.testMethod(age*3);
    }

    /* int 타입의 매개변수를 전달 받는 메소드 선언 */
    public void testMethod(int age){
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }
}

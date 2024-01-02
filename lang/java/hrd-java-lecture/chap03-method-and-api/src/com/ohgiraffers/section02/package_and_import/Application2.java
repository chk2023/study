package com.ohgiraffers.section02.package_and_import;

import com.ohgiraffers.section01.method.Calculator;

public class Application2 {
    public static void main(String[] args) {
        /* import에 대해 이해할 수 있다.
        * 매번 풀클래스명을 작성하기는 번거로우므로 패키지명을 생략하고 사용할 수 있도록 immport 구문을 사용한다.
        * import는 패키지 선언문과 class 선언문 사이에 작성하며 어떤 패키지 내에 있는 클래스를 사용할 것인지에 대해
        * 미리 선언하는 효과를 가진다. */
        Calculator calculator = new Calculator();
    }
}

package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /* AnnotationConfigApplicationContext 클래스를 사용하여 ApplicationContext를 생성한다.
        * 생성자에 @Configuration 어노테이션이 달린 설정 클래스의 메타 정보를 전달한다. */
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /* 1. bean의 id를 이용해서 bean을 가져오는 방법 */
//        MemberDTO member = (MemberDTO) applicationContext.getBean("member");

        /* 2. bean의 클래스 메타 정보를 전달하여 가져오는 방법 */
//        MemberDTO member = applicationContext.getBean(MemberDTO.class);

        /* 3. bean의 id와 클래스 메타 정보를 전달하여 가져오는 방법 */
        MemberDTO member = applicationContext.getBean("member", MemberDTO.class);

        System.out.println(member);

    }
}

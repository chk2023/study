package com.ohgiraffers.section03.annotationconfig.subsection02.xml;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("section03/annotationconfig/spring-context.xml");

        /* 스프링 컨테이너에서 생성 된 bean들의 이름을 배열로 반환한다. */
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println("bean name : " + beanName);
        }

        MemberDAO memberDAO = applicationContext.getBean("memberDAO", MemberDAO.class);

        System.out.println(memberDAO.selectMember(1));
        System.out.println(memberDAO.insertMember(new MemberDTO(3, "user03", "pass03", "신사임당")));
        System.out.println(memberDAO.selectMember(3));


    }
}

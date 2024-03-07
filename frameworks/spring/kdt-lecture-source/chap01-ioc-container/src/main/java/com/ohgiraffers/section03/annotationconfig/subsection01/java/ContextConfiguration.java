package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration("configurationSection03")
/* 베이스 패키지 설정이 없으면 해당 클래스의 현재 패키지 기준으로 컴포넌트 스캔이 수행 된다. */
@ComponentScan(
        basePackages = "com.ohgiraffers",
        excludeFilters = {
                @ComponentScan.Filter(
                        /* 1. 타입으로 설정 */
//                        type = FilterType.ASSIGNABLE_TYPE, classes = { MemberDAO.class }
                        /* 2. 어노테이션 종류로 설정 */
//                        type = FilterType.ANNOTATION, classes = { Component.class }
                        /* 3. 표현식으로 설정 */
                        type = FilterType.REGEX, pattern = {"com.ohgiraffers.common.*"}
                )
        },
        includeFilters = {
                /* excludeFilters 옵션과 작성하는 방식 동일 */

        }
)
public class ContextConfiguration {
}

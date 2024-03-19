package com.ohgiraffers.sessionlogin.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ohgiraffers.sessionlogin", annotationClass = Mapper.class)
public class MybatisConfiguration {
}

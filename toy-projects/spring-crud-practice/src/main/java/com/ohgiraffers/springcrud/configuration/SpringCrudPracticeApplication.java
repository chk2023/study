package com.ohgiraffers.springcrud.configuration;

import com.ohgiraffers.springcrud.actor.model.dao.ActorMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ohgiraffers.springcrud")
@MapperScan(basePackages = "com.ohgiraffers.springcrud", annotationClass = Mapper.class)
public class SpringCrudPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudPracticeApplication.class, args);
	}

}

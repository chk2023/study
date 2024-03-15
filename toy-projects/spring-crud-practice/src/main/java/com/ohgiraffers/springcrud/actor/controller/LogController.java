package com.ohgiraffers.springcrud.actor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class LogController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public LogController(ResourceLoader resourcesLoader) {
        this.resourceLoader = resourcesLoader;
    }

    @GetMapping("/log")
    public String getLog(Model model) {
        try {
            // 로그 파일을 로드
            Resource resource = resourceLoader.getResource(
                    "file:C:/workspace/study/toy-projects/spring-crud-practice/myapp.log");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            //로그 파일의 내용을 읽어와 문자열로 반환
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                log.append(line).append("\n");
            }
            reader.close();

            model.addAttribute("log", log.toString());
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("log", "로그를 출력할 수 없습니다.");
        }

        return "logs";
    }
}

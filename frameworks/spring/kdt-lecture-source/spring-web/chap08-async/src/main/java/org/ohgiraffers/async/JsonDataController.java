package org.ohgiraffers.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonDataController {
    @GetMapping("/json-data")
    public String showJsonData() {
        return "async/json-data";
    }

    /* @RequestBody : 요청 바디에 담긴 데이터를 java 객체에 매핑할 때 사용하는 어노테이션
    * 1. String
    * */
    @PostMapping("/jquery/json")
    public @ResponseBody String jqueryJsonTest(@RequestBody String requestBody) {

        System.out.println("requestBody : " + requestBody);

        return "success";
    }
}



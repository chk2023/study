package org.ohgiraffers.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorTestController {
    @GetMapping("/stopwatch")
    public String handlerMethod() throws InterruptedException {
        System.out.println("핸들러 메서드 호출함");

        Thread.sleep(1000);

        return "result";
    }
}

package com.ohgiraffers.chap02servicemethodlecturesource.section01.servicemethod;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /* 현재 사용 되는 프로토콜은 HTTP 프로토콜로, HttpServletRequest 타입이다.
        * HttpServletRequest는 ServletRequest를 상속 받아 구현했으며,
        * Http 프로토콜의 정보를 담고 있으므로 실제 사용 시에는 다운 캐스팅해서 사용해야 한다. */
        HttpServletRequest httpReqeust = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        /* 요청 받은 http 메서드가 어떤 메서드인지 판단한다. */
        String httpMethod = httpReqeust.getMethod();
        System.out.println("httpMethod : " + httpMethod);

        if ("GET".equals(httpMethod)) {
            doGet(httpReqeust, httpResponse);
        } else if ("POST".equals(httpMethod)){
            doPost(httpReqeust, httpResponse);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메서드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메서드 호출");
    }
}

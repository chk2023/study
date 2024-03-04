package com.ohgiraffers.chap09cookielecturesource.section01.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* redirect 처리 시 이전 request에 대한 정보는 존재하지 않는다.
         * 새로운 request 객체이므로 firstName, lastName은 null이다. */
        req.setCharacterEncoding("UTF-8");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName : " + firstName);
        System.out.println("lastName : " + lastName);

        /* 1. request에서 쿠키 목록을 쿠키 배열 형태로 꺼내온다.
         * 2. 쿠키의 getName과 getValue를 이용해 쿠키에 담긴 값을 사용한다. */
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if ("firstName".equals(cookie.getName())) {
                firstName = cookie.getValue();
            } else if ("lastName".equals(cookie.getName())) {
                lastName = cookie.getValue();
            }
        }

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>")
                .append("<html>")
                .append("<head>")
                .append("</head>")
                .append("<body>")
                .append("<h1>your first name is ")
                .append(firstName)
                .append(" and lastname is ")
                .append(lastName)
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        out.print(responseBuilder);
        out.close();

        /* 쿠키는 텍스트파일 형태로 클라이언트 컴퓨터에 저장 된다.
        * 공용 PC 등 다른 사용자와 함께 쓰는 PC면 보안에 취약하다.
        * 민감한 개인 정보를 취급하는 경우에는 쿠키보다 세션을 이용한다.
        * 세션은 쿠키와 유사한 형태로 key=value 쌍으로 저장되지만 서버에서 관리되므로
        * 보안에 더 우수하다는 장점을 가진다. */

    }

}











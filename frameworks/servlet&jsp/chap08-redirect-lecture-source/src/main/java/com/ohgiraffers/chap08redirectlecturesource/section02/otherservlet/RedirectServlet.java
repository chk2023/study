package com.ohgiraffers.chap08redirectlecturesource.section02.otherservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("이 servlet으로 redirect 성공!");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>")
                .append("<html>")
                .append("<head>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append("이 서블릿으로 redirect 성공!")
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        out.print(responseBuilder);
        out.close();
    }


}


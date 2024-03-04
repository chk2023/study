package com.ohgiraffers.chap10sessionlecturesource.section01.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 세션 객체를 꺼내 온다. */
        HttpSession session = req.getSession();
        System.out.println("redirect session id : " + session.getId());

        /* setAttribute한 값을 getAttribute로 꺼낼 수 있다. */
        String firstName = (String) session.getAttribute("firstName");
        String lastName = (String) session.getAttribute("lastName");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>")
                .append("<html>")
                .append("<head>")
                .append("</head>")
                .append("<body>")
                .append("<h1>your firstname is ")
                .append(firstName)
                .append(" and lastname is ")
                .append(lastName)
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        out.print(responseBuilder);
        out.close();
    }
}

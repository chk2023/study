package com.ohgiraffers.chap05responselecturesource.section02.headers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/headers")
public class ResponseHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("Refresh", "10");

        PrintWriter out = resp.getWriter();

        long currentTime = System.currentTimeMillis();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>")
                .append("<html>")
                .append("<head>")
                .append("</head>")
                .append("<body>")
                .append("<h1>" + currentTime + "</h1>")
                .append("</body>")
                .append("</html>");

        out.print(responseBuilder);
        out.close(); //close()를 하면 자동으로 flush가 된다.

        /*  */
        Collection<String> responseHeader = resp.getHeaderNames();
        Iterator<String> iter = responseHeader.iterator();
        while (iter.hasNext()) {
            String headerName = iter.next();
            System.out.println(headerName + " : " + resp.getHeader(headerName));
        }

    }
}

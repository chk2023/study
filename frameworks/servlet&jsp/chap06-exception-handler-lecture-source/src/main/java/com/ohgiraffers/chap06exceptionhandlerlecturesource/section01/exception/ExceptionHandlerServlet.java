package com.ohgiraffers.chap06exceptionhandlerlecturesource.section01.exception;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> attrName = req.getAttributeNames();
        while(attrName.hasMoreElements()) {
            System.out.println(attrName.nextElement());
        }

        String forwardRequestURI = (String) req.getAttribute("javax.servlet.forward.request_uri");
        String contextPath = (String) req.getAttribute("javax.servlet.forward.context_path");
        String servletPath = (String) req.getAttribute("javax.servlet.forward.servlet_path");
        HttpServletMapping mapping = req.getHttpServletMapping();
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String message = (String) req.getAttribute("javax.servlet.error.message");
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");
        String errorRequestURI = (String) req.getAttribute("javax.servlet.error.request_uri");

        System.out.println(forwardRequestURI);
        System.out.println(contextPath);
        System.out.println(servletPath);
        System.out.println(mapping);
        System.out.println(mapping.getServletName());
        System.out.println(mapping.getMatchValue());
        System.out.println(mapping.getPattern());
        System.out.println(mapping.getMappingMatch());
        System.out.println(statusCode);
        System.out.println(message);
        System.out.println(servletName);
        System.out.println(errorRequestURI);

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>")
                .append("<html>")
                .append("<head>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append(statusCode)
                .append(" - ")
                .append(message)
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        out.print(responseBuilder);
        out.close();
    }
}
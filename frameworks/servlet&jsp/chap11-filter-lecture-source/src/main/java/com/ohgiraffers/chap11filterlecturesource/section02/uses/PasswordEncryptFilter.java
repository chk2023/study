package com.ohgiraffers.chap11filterlecturesource.section02.uses;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /* member와 관련한 기능은 기존 request 객체를 RequestWrapper 객체로 감싸서 서블릿으로 넘긴다. */
        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;
        RequestWrapper wrapper = new RequestWrapper(hrequest);
        filterChain.doFilter(wrapper, servletResponse);
    }
}

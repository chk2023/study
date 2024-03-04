package com.ohgiraffers.chap11filterlecturesource.section02.uses;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/* 필터 등록은 web.xml(배포 서술자) 파일에서 처리한다. */
public class EncodingFilter implements Filter {

    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;
        if("POST".equals(hrequest.getMethod())) {
            servletRequest.setCharacterEncoding(encodingType);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}

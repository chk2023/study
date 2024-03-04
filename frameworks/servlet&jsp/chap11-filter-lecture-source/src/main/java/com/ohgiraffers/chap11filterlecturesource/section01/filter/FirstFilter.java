package com.ohgiraffers.chap11filterlecturesource.section01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/first/*")
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("FirstFilter 인스턴스 생성!");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init 호출!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /* Servlet으로 request가 전달 되지 전에 요청을 가로채는 역할을 하는 메소드 */
        System.out.println("Filter doFilter 호출!");

        /* 필터에서 처리할 코드를 작성한다. */

        /* 필터에서 처리 한 뒤 다음 필터 혹은 서블릿을 호출한다. */
        filterChain.doFilter(servletRequest, servletResponse);

        /* 서블릿에서 처리 후에 다시 수행할 내용이 있으면 작성한다. */
        System.out.println("Servlet 요청 수행 완료!");
    }

    @Override
    public void destroy() {
        System.out.println("Filter destory 호출!");
    }
}

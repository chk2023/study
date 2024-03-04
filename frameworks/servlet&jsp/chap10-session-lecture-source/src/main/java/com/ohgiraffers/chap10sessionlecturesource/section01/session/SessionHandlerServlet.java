package com.ohgiraffers.chap10sessionlecturesource.section01.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

       String firstName = req.getParameter("firstName");
       String lastName = req.getParameter("lastName");

       /* 쿠키의 보안상 단점과 지원하지 않는 브라우저 문제 등으로 상태 유지 매커니즘에 적합하지 않은
       * 경우가 다수 있다. 특히 회원 정보를 이용해서 로그인 상태를 유지해야 하는 경우가 그렇다.
       * 따라서 서버 쪽에서 안전하게 관리 되는 세션이라는 인스턴스를 통해 상태 유지 매커니즘을 제공한다.
       * */
        HttpSession session = req.getSession();

        /* 세션은 브라우저 당 한 개씩 고유의 아이디를 가지고 하나의 인스턴스를 이용한다.
        * 매번 반복 요청 시 동일한 session id를 반환한다.
        * 브라우저가 종료 되면 해당 세션은 종료 된다. */
        System.out.println("session id : " + session.getId());

        /* 세션의 기본 유지 시간은 30분이며 필요에 따라 늘이거나 줄일 수 있다. */
        System.out.println("session default 유지 시간 : " + session.getMaxInactiveInterval());
        session.setMaxInactiveInterval(60 * 10);    // 10분으로 변경
        System.out.println("session 변경 후 유지 시간 : " + session.getMaxInactiveInterval());

        /* 세션은 redirect를 해도 값을 유지할 수 있으므로, request보다 더 넓은 범위의 공유 영역이라고 할 수 있다.
        * 세션에 값을 담을 때는 setAttribute(String key, Object value) 형태로 담을 수 있고,
        * 값을 꺼낼 때는 getAttribute(String key)로 꺼낼 수 있다.
        * */
        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        resp.sendRedirect("redirect");
    }










}

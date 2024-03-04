package com.ohgiraffers.chap10sessionlecturesource.section02.delete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Enumeration<String> sessionNames = session.getAttributeNames();
        while(sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }

        /* 세션의 데이터를 제거하는 방법은 여러가지가 있다.
        * 1. 설정한 만료 시간이 지나면 세션이 만료 된다.
        * 2. removeAttribute()로 속성을 제거한다.
        * 3. invalidate()를 호출하면 세션의 모든 데이터가 제거 된다.
        * */

        System.out.println("-------------------------------");

        session.removeAttribute("firstName");
        sessionNames = session.getAttributeNames();
        while(sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }

        System.out.println("-------------------------------");
        /* invalidate를 호출하면 세션 자체를 무효화 했기 때문에 그 이후에 세션을 사용하려 하면 에러가
        * 발생한다. 즉, 세션 내의 데이터를 지우는 것 뿐 아니라 세션을 강제로 만료 시켰다고 볼 수 있다. */
        session.invalidate();
        sessionNames = session.getAttributeNames();
        while(sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }
    }

}

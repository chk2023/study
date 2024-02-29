package com.ohgiraffers.chap07forwardlecturesource.section01.forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("userId : " + userId);
        System.out.println("password : " + password);

        /* 비즈니스 로직은 성공했다는 가정 하에 입력된 아이디를 이용해서 XXX님 환영합니다 라는 메시지를
        * 출력하는 화면을 응답한다.
        * => 응답을 하기 위한 전용 서블릿을 만들고 서블릿에서 응답할 수 있도록 위임한다.
        * */

        req.setAttribute("userId", userId);

        /* 어떤 서블릿으로 위임할 것인지 대상 서블릿을 지정하는 RequestDispatcher 인스턴스를
        * 경로를 넣어 지정하고 forward 메서드로 요청과 응답에 대한 정보를 전달하여 이후 작업을 수행하도록 위임한다. */
        RequestDispatcher rd = req.getRequestDispatcher("print");
        rd.forward(req, resp);

    }
}
















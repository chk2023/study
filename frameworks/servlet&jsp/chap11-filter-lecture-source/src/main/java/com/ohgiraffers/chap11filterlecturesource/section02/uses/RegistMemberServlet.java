package com.ohgiraffers.chap11filterlecturesource.section02.uses;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* post 전송 시 한글 깨짐 현상, 비밀번호 암호화 처리가 문제인 상황
        * => 각각의 서블릿에 코드를 작성할수도 있지만 filter를 통해 공통적으로 처리하면
        * 보다 효율적으로 처리할 수 있고 변경 시에도 손쉽게 변경할 수 있다. */
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        System.out.println("userId : " + userId);
        System.out.println("password : " + password);
        System.out.println("name : " + name);

        /* 암호화 된 패스워드는 동일 값이 입력 되더라도 매번 실행 시마다 다른 값을 가지게 된다.
        * DB에 이 값이 기록 되면 로그인시 비밀번호가 같은지 여부를 어떻게 비교할 수 있을까?
        * 해당 라이브러리의 matches 라는 메소드를 이용해서 확인한다.
        * */
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("비밀번호가 pass01인지 확인 : "
                + passwordEncoder.matches("pass01", password));
        System.out.println("비밀번호가 pass02인지 확인 : "
                + passwordEncoder.matches("pass02", password));

    }
}

package com.ohgiraffers.chap03parameterlecturesource.section01.querystring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* HttpServletRequest 객체로부터 요청 시 전달한 값을 getParameter 메서드로 추출해올 수 있다.
        * 인자로 input 태그에 지정한 name 속성 값을 문자열 형태로 전달한다.
        * 모든 input 태그의 값을 HashMap으로 관리하고 있으므로 원하는 값을 찾기 위해서는 key 역할을 하는 문자열이 필요하다. */
        String name = req.getParameter("name");
        System.out.println("이름 : " + name);

        /* getParameter 메서드는 반환 타입이 문자열이다. 다른 형식의 값이 필요하다면 parsing한다. */
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("나이 : " + age);

        /* 날짜와 관련된 부분도 parsing이 필요하다. */
        java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println("생일 : " + birthday);

        /* 라디오 버튼으로 전달 된 값은 여러 값 중 선택한 하나의 값만 전달 되므로 parameter로 전달된 값을
        * 꺼내기만 하면 된다. */
        String gender = req.getParameter("gender");
        System.out.println("성별 : " + gender);

        String national = req.getParameter("national");
        System.out.println("국적 : " + national);

        /* checkbox는 다중으로 입력을 받을 수 있으므로 선택 된 값이 문자열 배열로 전달 된다.
        * getParameterValues 메서드를 이용한다. */
        String[] hobbies = req.getParameterValues("hobbies");
        for (String hobby : hobbies) {
            System.out.print(hobby + " ");
        }
    }
}

package com.ohgiraffers.chap03parameterlecturesource.section02.formdata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* GET 방식의 데이터는 HTML charset에 기술 된 인코딩 방식으로 브라우저가 한글을 이해하고, %문자로 URLEncoder를 이용해
         * 변환한 뒤 url 요청으로 전송한다. 이 때 header의 내용은 ascii 코드로 전송 되기 때문에 어떤 언어든 서버의 설정 인코딩
         * 방식과 맞기만 하면 해석에 문제가 없어 한글 값이 깨지지 않는다.
         * GET 요청은 보통 서버의 리소스를 가져오는 행위를 요청하는 http 요청 방식이기 때문에 별도의 데이터가 필요 없어
         * 요청 body(페이로드)는 해석하지 않는다.
         *
         * POST 요청은 서버의 리소스에 내용을 추가하는 요청이기 때문에 요청하는 데이터가 필요한 경우가 대부분이다.
         * 서버의 리소스에 추가해야 하는 정보를 페이로드에 key&value 방식으로 담아 전송하는데, 헤더와는 별개로 URLEncoder를
         * 이용하지 않고 페이지 meta에 기술 된 charset에 따라 UTF-8로 해석 된 데이터를 서버로 전송한다.
         * 서버에 페이로드를 디코딩하는 방식은 지정되어 있지 않으므로 request.getCharacterEncoding()을 호출하면 null이 반환되는데
         * default로는 ISO-8859-1로 해석하므로 한글이 깨지는 현상이 발생한다.
         * */

        System.out.println(req.getCharacterEncoding());

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        System.out.println("이름 : " + name);

        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("나이 : " + age);

        java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println("생일 : " + birthday);

        String gender = req.getParameter("gender");
        System.out.println("성별 : " + gender);

        String national = req.getParameter("national");
        System.out.println("국적 : " + national);

        String[] hobbies = req.getParameterValues("hobbies");
        for (String hobby : hobbies) {
            System.out.print(hobby + " ");
        }
    }
}

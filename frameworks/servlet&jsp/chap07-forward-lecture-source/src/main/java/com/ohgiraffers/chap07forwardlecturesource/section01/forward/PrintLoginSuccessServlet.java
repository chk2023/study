package com.ohgiraffers.chap07forwardlecturesource.section01.forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* forward 된 서블릿에서도 요청 방식이 그대로 유지 된다. (Post -> Post)
         * forward 할 때 전달한 request, response의 모든 정보를 이용해 새로운 request, response를
         * 깊은 복사를 통해 만들어 전달하므로 데이터를 그대로 유지하고 있다. */

        /* parameter => 클라이언트에서 전송된 데이터
         * attribute => request 객체가 가지는 속성으로 request가 유지되는 동안 데이터를 보존 */
        String userId = (String) req.getAttribute("userId"); // 반환 타입이 Object여서 다운 캐스팅 해준다.

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>")
                .append("<html>")
                .append("<head>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append(userId)
                .append("님 환영합니다.")
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        out.print(responseBuilder);
        out.close();
    }

    /* forward 방식을 통해 다른 서블릿으로 위임하더라도 데이터를 공유 할 수 있다.
    * forward 동작을 클라이언트가 알 필요가 없으므로 요청 url은 변경 되지 않는다.
    * 새로고침(=재요청)하게 되면 동일한 요청을 반복하게 되는데,
    * 이 때 데이터베이스에 insert하는 등의 행위를 하게 되면 중복 행이 삽입될 가능성이 있다.
    * => 이러한 경우에는 redirect 방식으로 응답을 해주어야 한다.
    * */


}

<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2024-03-05
  Time: 오전 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>전달된 request 객체에 저장된 정보 출력하기</h1>

name : ${ requestScope.name } <br>
age : ${ requestScope.age } <br>
phone : ${ requestScope.phone } <br><br>

name : ${ name } <br>
age : ${ age } <br>
phone : ${ phone } <br><br>

0 : ${ requestScope.items[0] } <br>
1 : ${ requestScope.items[1] } <br>
2 : ${ requestScope.items[2] } <br><br>

</body>
</html>

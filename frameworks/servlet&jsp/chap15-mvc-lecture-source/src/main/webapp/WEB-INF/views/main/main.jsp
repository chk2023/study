<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>

    <h1>employee 테이블에서 emp_id를 이용하여 사원 정보 조회해오기</h1>
    <form action="${pageContext.servletContext.contextPath}/employee/select">
        <label>조회할 사원 : </label>
        <input type="text" name="empId" id="empId">
        <button>조회하기</button>
    </form>

    <h1>employee 테이블에서 직원 전체 정보 조회(퇴사하지 않은 직원만 조회)</h1>
    <button onclick="location.href='${pageContext.servletContext.contextPath}/employee/list'">
        직원 정보 전체 조회하기
    </button>



</body>
</html>

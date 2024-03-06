<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
    <h2>번호로 배우 정보 조회</h2>
    <form action="${pageContext.servletContext.contextPath}/actor/select">
        <label>번호 : </label>
        <input type="text" name="actorId" id="actorId">
        <button>조회하기</button>
    </form>

    <h2>배우의 출연영화 조회</h2>
    <button onclick="location.href='${pageContext.servletContext.contextPath}/actor/list'">
        전체 조회
    </button>

    <h2>배우 정보 추가</h2>
    <form action="${ pageContext.servletContext.contextPath }/employee/insert" method="post">
        이름 : <input type="text" name="firstName"/><br>
        성 : <input type="text" name="lastName"/><br>
        <button type="submit">등록하기</button>
    </form>

    <h2>배우 정보 수정</h2>
    <form action="${ pageContext.servletContext.contextPath }/actor/update" method="post">
        번호 : <input type="text" name="actorId"/><br>
        이름 : <input type="text" name="firstName"/><br>
        성 : <input type="text" name="lastName"/><br>
        <button type="submit">정보 수정</button>
    </form>

    <h2>배우 정보 삭제</h2>
    <form action="${ pageContext.servletContext.contextPath }/actor/delete" method="post">
        번호 : <input type="text" name="actorId"/>
        <button type="submit">정보 삭제</button>
    </form>

</body>
</html>

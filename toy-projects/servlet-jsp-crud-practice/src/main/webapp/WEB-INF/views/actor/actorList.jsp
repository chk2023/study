<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>배우 필모그래피</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>배우 필모그래피 전체 조회</h1>
    <table>
        <tr>
            <th>배우 번호</th>
            <th>배우 이름</th>
            <th>배우 성</th>
            <th>마지막 업데이트</th>
            <th>출연 영화</th>
        </tr>
        <c:forEach items="${ actorList }" var="actor">
            <tr>
                <td>${ actor.actorId }</td>
                <td>${ actor.firstName }</td>
                <td>${ actor.lastName }</td>
                <td>${ actor.lastUpdate }</td>
                <td>${ actor.title }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>배우 정보</title>
</head>
<body>
    <h2>${ param.actorId }번 배우의 정보</h2>
    <h4>배우 이름 : ${ selectedActor.firstName }</h4>
    <h4>배우 성 : ${ selectedActor.lastName }</h4>
    <h4>마지막 업데이트 : ${ selectedActor.lastUpdate }</h4>
</body>
</html>

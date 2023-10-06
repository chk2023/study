https://dev-coco.tistory.com/97

**REST**
REpresentational State Transfer: 자원의 표현에 의한 상태 전달
자원: 소프트웨어가 관리하는 모든 것 (문서, 그림, 데이터 등)
표현: 그 자원을 표현하기 위한 이름 (DB의 학생 정보가 자원이면, students가 표현)
상태전달: 데이터가 요청되는 시점에 자원의 상태. 

어떤 자원에 대해 CRUD 연산을 수행하기 위해 URI(자원)로 GET, POST 등의 방식(메소드)을 사용하여 요청을 보내고, 요청을 위한 자원은 특정한 형태로 표현된다.

HTTP URI(Uniform Resource Identifier)를 통해 자원(Resource)을 명시하고, HTTP Method(POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CRUD Operation을 적용하는 것을 의미한다.

REST의 구성 요소
1. 자원 (URI)
	모든 자원에는 고유한 ID가 존재하고, 이 자원은 서버에 존재한다. 
2. 행위 (Method)
	HTTP 프로토콜의 Method를 사용한다.
3. 표현 (Reperentation of Resource)
	클라이언트와 서버가 데이터를 주고받는 형태: JSON, XML, TEXT, RSS 등.

**RESTful**
REST API를 제공하는 웹 서비스를 RESTful하다고 할 수 있다.
REST의 설계 규칙을 잘 지켜서 설계된 것을 뜻한다.

**REST API**
API는 데이터와 기능의 집합을 제공하여 컴퓨터 프로그램 간 상호작용을 가능하게 한다. 
REST API는 REST 기반으로 서비스 API를 구현한 것이다. 

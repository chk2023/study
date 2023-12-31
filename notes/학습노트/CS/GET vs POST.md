https://brilliantdevelop.tistory.com/33

GET 방식
GET은 요청을 전송할 때 필요한 데이터를 Body에 담지 않고, 쿼리스트링을 통해 전송한다.
URL의 끝에 ?와 함께 이름과 값으로 쌍을 이루는 요청 파라미터를 쿼리스트링. 파라미터가 여러개일 경우 &로 연결.
예) www.example.com/resources?name1=value1&name2=value2

POST 방식
GET 방식과 다르게 HTTP 메시지의 Body에 담아서 데이터를 전송한다. HTTP 메시지의 Body는 길이의 제한없이 데이터를 전송할 수 있다. 따라서 대용량 데이터를 전송할 수 있다. 

POST 방식이 GET 방식과 다르게 내용이 URL에 보이지 않아 안전하다 생각할 수 있지만 크롬 개발자 도구, Fiddler와 같은 툴로 요청 내용을 확인할 수 있다. 민감한 데이터는 반드시 암호화해야 한다.
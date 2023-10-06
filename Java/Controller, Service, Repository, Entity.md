https://velog.io/@jybin96/Controller-Service-Repository-%EA%B0%80-%EB%AC%B4%EC%97%87%EC%9D%BC%EA%B9%8C

Controller
사용자가 요청을 받고 Service에게 처리의 결정을 넘긴다.
지정된 뷰에 모델 객체를 넘겨주는 역할을 한다.

Service
Repository와 controller 사이 미들웨어다.
Controller에서 받은 요청을 처리한다. (비즈니스 로직)
Controller로 받은 데이터를 가공해서 DB로 보내거나 DB에서 가져온 데이터를 가공해서 사용자에게 보내준다.

Repository
[[03장 스프링 부트에서 JPA로 데이터베이스를 다뤄보자]]
Mybatis << sql 문을 직접 적어서 디비에서 꺼내서 쓰는거

Jpa(ORM 프레임워크 하이버네이트) << sql문을 finaAll()이런 인터페이스를 부르면 그 인터페이스가 만들어져있는 sql을 실행시켜줘서 디비에서 꺼내서 쓰는거

질문: SQL을 몰라도 될까?

Entity에 의해 생성된 DB에 접근하는 메서드(ex) finaAll())를 사용하기 위한 인터페이스. 
엔티티를 통해 데이터베이스 구조를 만들었다면 CRUD에 대해 정의하는 것이 레파지토리.

Entity
데이터베이스의 구조를 만든다.
데이터베이스에 쓰일 필드와 여러 엔티티간 연관관계를 정의한다. 
DB의 테이블이 엔티티이며 각 행들이 엔티티 객체가 되는 것이다. 
엔티티의 각 column이 필드가 된다.
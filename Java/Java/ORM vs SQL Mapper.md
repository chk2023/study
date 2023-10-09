자바의 표준 ORM은 JPA.
SQL Mapper의 예로는 MyBatis가 있다.

https://deveun.tistory.com/entry/SQL-Mapper%EC%99%80-ORM-%EC%B0%A8%EC%9D%B4

프로그램을 실행하는 동안 그 안에서는 많은 데이터들이 사용되고 만들어진다.
프로그램이 종료되어도 사라지지 않고 어떤 곳에 저장되는 개념이 영속성이다.

![[Pasted image 20231002215821.png]]
Layered Architecture에서 영속성 layer는 도메인 모델과 데이터베이스 사이에 존재하며, 프로그램의 객체정보를 DB에 저장하고, DB의 정보를 객체로 담아와 사용한다.

자바에서는 데이터의 영속성을 위한 JDBC를 지원해주는데, JDBC는 DB에 접근하여 SQL을 수행하고, 결과 값을 다시 dataType으로 매핑시켜주는 작업을 개발자가 일일이 수행해야 한다.
SQL Mapper와 ORM은 개발자가 직접 JDBC 프로그래밍을 하지 않도록 기능을 제공하는 Persistence Framework다.

SQL Mapper (JdbcTemplate, Mybatis)
Object와 SQL의 필드를 매핑하여 데이터를 객체화하는 기술.
SQL문을 직접 작성하고 쿼리 수행결과를 어떠한 객체에 매핑.

MyBatis
SQL을 xml파일로 분리하여 관리하고, SQL결과와 객체 인스턴스의 매핑을 도와주는 역할 수행.

ORM
Object와 DB 테이블을 매핑하여 데이터를 객체화하는 기술.
개발자가 반복적인 SQL을 직접 작성하지 않아도 되고, DBMS에 종속적이지 않다. 
Java ORM 기술에 대한 인터페이스 표준이 JPA이고, 이를 구현한 가장 대표적인 기술이 Hibernate다.
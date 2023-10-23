예전에는 iBatis(현재는 MyBatis)와 같은 SQL 매퍼를 이용해서 데이터베이스의 쿼리를 작성했다.
그러다 보니 실제 개발하는 시간보다 SQL을 다루는 시간이 많아졌다.
객체 모델링보다는 테이블 모델링에만 집중하고, 객체를 단순히 테이블에 맞추어 데이터 잔달 역할만 하는 개발이 되었다.

문제의 해결책은 자바 표준 ORM(Object Relational Mapping)인 JPA다.
SI 환경에서는 Spring & MyBatis를 많이 사용. 네카라쿠배는 SpringBoot & JPA를 전사 표준으로.

**JPA 소개**
관계형 데이터베이스와 객체지향 프로그래밍은 패러다임이 불일치한다.
관계형 데이터베이스는 어떻게 데이터를 저장할지에 초점이 맞춰져 있다.
객체지향 프로그래밍 언어는 메시지를 기반으로 기능과 속성을 한 곳에서 관리하는 기술이다.
관계형 데이터베이스로 객체지향을 표현하기는 쉽지 않다.

개발자는 객체지향적으로 프로그래밍 하고, JPA가 이를 관계형 데이터베이스에 맞게 SQL을 대신 생성해서 실행한다. 개발자는 SQL에 종속적인 개발을 하지 않아도 된다.

**Sping Data JPA**
JPA는 인터페이스로서 자바 표준명세서다. 인터페이스인 JPA를 사용하기 위해서는 구현체가 필요하다. Hibernate, Eclipse Link 등이 있지만 스프링에서는 이들을 사용하지 않는다.
구현체들을 좀 더 쉽게 사용하고자 추상화시킨 Spring Data JPA라는 모듈을 이용하여 JPA 기술을 다룬다. 

Spring Data JPA를 사용하는 이유는 구현체 교체와 저장소 교체가 쉽기 때문이다.
Hibernate가 언젠간 수명을 다해 새로운 JPA 구현체가 대세로 떠오르면 Spring Data JPA를 사용해 교체할 수 있다. 

저장소 교체의 용이성이란 관계형 데이터베이스 외에 다른 저장소로 쉽게 교체하기 위함이다. 
MongoDB로 교체가 필요하다면 Spring Data JPA에서 Spring Data MongoDB로 의존성만 교체하면 된다. 
Spring Data의 하위 프로젝트들은 기본적인 CRUD의 인터페이스가 같다.
Spring Data JPA, Spring Data Redis, Spring Data MongoDB 등의 하위 프로젝트들은 save(), findAll, findOne() 등을 인터페이스로 갖고 있다. 

**실무에서 JPA**
실무에서 JPA를 사용하지 못하는 가장 큰 이유는 높은 러닝 커브다.
JPA를 잘 사용하려면 객체지향 프로그래밍과 데이터베이스를 둘 다 이해해야 한다.

JPA를 사용하면 좋은 점은 CRUD 쿼리를 직접 작성할 필요가 없다. 
부모-자식 관계 표현, 1:N 관계 표현, 상태와 행위를 한 곳에서 관리하는 등 객체지향 프로그래밍을 쉽게 할 수 있다.

3-6장 게시판 만들기
7-10장 AWS 무중단 배포

domain 패키지를 만들었다. 여기서 도메인은 게시글, 댓글, 회원, 정산, 결제 등 소프트웨어에 대한 요구사항 혹은 문제영역.
domain 패키지 아래 posts 패키지를 만들고 그 안에 Posts 클래스 파일 생성.

필자는 어노테이션 순서를 주요 어노테이션일수록 클래스에 가깝게 둔다.
@Entity는 JPA의 어노테이션이며, @Getter와 @NoArgsConstructor는 롬복의 어노테이션이다.
롬복은 코드를 단순화시켜 주지만 필수는 아니다. 따라서 주요 어노테이션인 @Entity를 클래스에 가깝게 배치한 것이다. 

Posts 클래스에는 JPA에서 제공하는 어노테이션들이 있다.
@Entity
테이블과 링크될 클래스임을 나타낸다. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭한다.

@Id
해당 테이블의 PK 필드를 나타낸다.

@GeneratedValue
PK의 생성 규칙을 나타낸다. auto increment 등.

@Column
테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용.
예) 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나, 타입을 TEXT로 변경하고 싶거나 등의 경우 사용.

웬만하면 Entity의 PK는 Long 타입의 Auto_increment 추천. pg 91.

@NoArgsConstructor
기본 생성자 자동 추가.
public Posts(){}와 같은 효과.

@Getter
클래스 내 모든 필드의 Getter 메소드 자동생성.

@Builder
해당 클래스의 빌더 패턴 클래스를 생성
생성자 상단에 선언 시 생성자에 포함된 빌드만 빌더에 포함.

@Entity를 적용하는 클래스는 테이블 설계를 하는 행위라고 이해하면 쉽다.
Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다. 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야 한다.

Setter 없이 어떻게 DB에 값을 삽입할까?
생성자를 통해 최종값을 채운 후 DB에 삽입하며, 값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경한다.
이 책에서는 생성자 대신 @Builder를 통해 제공되는 빌더 클래스를 사용한다. 생성자나 빌더나 생성 시점에 값을 채워주는 역할을 한다. 하지만 생성자는 지금 채워야 할 필드가 무엇인지 명확히 지정할 수 없다.

Posts 클래스 생성이 완료되었으면 Posts 클래스로 데이터베이스를 접근하게 해 줄 JpaRepository를 생성한다. 

MyBastis 등에서 Dao라고 불리는 DB Layer 접근자를 JPA에선 Repository라고 부르며 인터페이스로 생성한다. 단순히 인터페이스를 생성한  JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동 생성된다.
@Repository를 추가할 필요도 없다. 단, 주의할 점은 Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다. 프로젝트 규모가 커지면 Entity 클래스와 Repository는 함께 움직어야 하므로 도메인 패키지에서 함께 관리한다.

**Spring Data JPA 테스트 코드 작성**
@After
Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정.
보통은 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용.
여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아 있어 다음 테스트 실행 시 테스트가 실패할 수 있다.

@postsRepository.save
테이블 posts에 insert/update 쿼리를 실행한다.
id 값이 있다면 update가, 없다면 insert 쿼리가 실행된다. 

@postsRepository.findAll
테이블 posts에 있는 모든 데이터를 조회해오는 메소드다.

별다른 설정 없이 @SpringBootTest를 사용하면 H2 데이터베이스를 자동으로 실행한다. 

실제 실행된 쿼리가 궁금하다면 로그를 볼 수 있게 설정할 수 있다.
src/main/resources 디렉토리에 application.properties를 만들고 다음 코드를 추가.
```
spring.jpa.show-sql=true
```

create table 쿼리를 보면 id bigint genereated by default as identity라는 옵션으로 생성된다. 이는 H2의 쿼리 문법이 적용되었기 때문이다. H2는 MySQL의 쿼리를 수행해도 정상적으로 작동하기 때문에 이후 디버깅을 위해서 출력되는 쿼리 로그를 MySQL 버전으로 변경해보자. 코드 추가.
```
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
```
! 하지만 statement를 불러올 수 없다고 한다. 그냥 빼고 하기.

**등록/수정/조회 API 만들기**
API를 만들기 위해 총 3개의 클래스가 필요하다. 
Request 데이터를 받은 Dto
API 요청을 받을 Controller
트랜잭션, 도메인 기능 간의 순서를 보장하는 Service

Service에서 비즈니스 로직을 처리해야 한다는 것은 큰 오해다. Service는 트랜잭션, 도메인 간 순서 보장의 역할만 한다.
![[Pasted image 20231002101312.png]]
Web Layer
흔히 사용하는 컨트롤러(@Controller)와 JSP/Freemarker 등의 뷰 템플릿 영역.
이외에도 필터(@Filter), 인터셉터, 컨트롤러 어드바이스(@ControllerAdvice)등의 
외부요청과 응답에 대한 전반적인 영역을 이야기한다.

Service Layer
@Service에 사용되는 서비스 영역이다.
일반적으로 Controller와 Dao(Data Access Object)의 중간 영역에서 사용된다.
@Transactional이 사용되어야 하는 영역이기도 하다.

Repository Layer
데이터베이스와 같이 데이터 저장소에 접근하는 영역이다.
Dao영역으로 이해하면 쉽다.

Dtos
Dto(Data Transfer Object)는 계층 간에 데이터 교환을 위한 객체를 말한다. Dtos는 이들의 영역.
예) 뷰 템플릿 엔진에서 사용될 객체나 Repository Layer에서 결과로 넘겨준 객체 등을 말한다.

Domain Model
도메인은 개발 대상.
도메인을 모든 사람이 동일한 관점에서 이해할 수 있고 공유할 수 있도록 단순화 시킨 것을 도메인 모델이라고 한다.
예) 택시 앱에서는 배차, 탑승, 요금 등이 모두 도메인이라고 할 수 있다.
@Entity가 사용된 영역 역시 도메인 모델. 무조건 DB의 테이블과 관계가 있어야 하는 것은 아니다.
VO처럼 값 객체들도 이 영역에 해당하기 때문.

그렇다면 Web, Service, Repository, Dto, Domain, 이 다섯 가지 레이어에서 비지니스 처리를 담당해야 하는 곳은? 바로 Domain이다.
기존에 서비스로 처리하던 방식을 트랜잭션 스크립트라고 한다.
모든 로직이 서비스 클래스 내부에서 처리되며 서비스 계층이 무의미해지고 객체는 단순히 데이터 덩어리 역할만 하게 되었다.

CRUD 기능을 만들어보자.
service.posts 디렉토리에 PostsService,  dto 디릭토리에 PostsSaveRequestDto, web디렉토리에 PostsApiController 생성.

스프링을 써봤던 사람이라면 Controller나 Service에 Autowired가 없는 것이 어색할 수 있다. 스프링에서 Bean을 주입받는 방식은 다양하다. @Autowired, setter, 생성자.
롬복에서 final이 선언된 모든 필드를 인자값으로 하는 생성자를 @RequiredArgsConstructor을 통해 생성한다.
생성자를 직접 안 쓰고 롬복 어노테이션을 사용하는 이유는 해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정해야 하기 때문.

Controller와 Service에서 사용할 Dto 클래스를 생성하자.
Entity 클래스와 거의 유사한 형태 임에도 Dto 클래스를 추가로 생성했다.
하지만 절대로 Entity 클래스를 Request/Response 클래스로 사용해서는 안 된다.
Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스다. Entity 클래스를 기준으로 테이블이 생성되고, 스키마가 변경된다. 사소한 화면 변경을 위해 테이블과 연결된 Entity 클래스를 변경하는 것은 너무 큰 변경이다. 
Request와 Response용 Dto는 뷰를 위한 클래스라 자주 변경이 필요하다. 
즉 View Layer와 DB Layer의 역할 분리를 철저하게 하는 것이 좋다. 

Api Controller를 테스트하는데 HelloController와 달리 @WebMvcTest를 사용하지 않았다. @WebMvcTest의 경우 JPA 기능이 작동하지 않기 때문.
JPA 기능까지 한번에 테스트할 때는 @SpringBootTest와 TestRestTemplate를 사용하면 된다.

테스트를 통과했으니 수정, 조회 기능도 만든다.
PostsResponseDto는 Entity의 필드 중 일부만 사용하므로 생성자로 Entity를 받아 필드에 값을 넣는다. 

JPA의 엔티티 매니저가 활성화된 상태로 트랜잭션 안에서 데이터베이스에서 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태다. 
이 상태에서 해당 데이터의 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영한다. Entity 객체의 값만 변경하면 별도로 Update 쿼리를 날릴 필요가 없다는 것. 이를 더티 체킹이라고 한다.
코드가 정상적으로 Update 쿼리를 수행하는지 테스트 코드로 확인.

실제 톰캣을 실행해서 확인하기.
application.properties에 spring.h2.console.enabled=true 추가.
http://localhost:8080/h2-console/ 접속.
연결이 안 돼서 application.properties에 spring.datasource.url=jdbc:h2:mem:testdb을 추가했다.
필드에 값을 insert 해주고 http://localhost:8080/api/v1/posts/1 에서 API 요청 확인.

**JPA Auditing으로 생성시간/수정시간 자동화하기**
보통 엔티티에는 해당 데이터의 생성시간과 수정시간을 포함한다.
간단하게 JPA Auditing을 사용한다. 
도메인 패키지에 BaseTimeEntity 클래스를 생성한다.

BaseTimeEntity 클래스는 모든 Entity의 상위 클래스가 되어 Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할을 한다.

@MappedSuperclass
JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드(createdData, modifiedDate)도 칼럼으로 인식하도록 한다.

@EntityListeners(AuditingEntityListener.class)
BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.

@CreatedDate
Entity가 생성되어 저장될 때 시간이 자동 저장된다.

@LastModifiedDate
조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.

Posts 클래스가 BaseTimeEntity를 상속받도록 변경한다.
마지막으로 JPA Auditing 어노테이션을 모두 활성화할 수 있게 Application 클래스에 활성화 어노테이션 하나를 추가한다.

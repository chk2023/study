여기서 도메인은 게시글, 댓글, 회원, 정산, 결제 등 소프트웨어에 대한 요구사항 혹은 문제영역.

### Posts
@Getter
모든 필드 getter(접근자)가 자동으로 생성된다. 

@NoArgsConstructor
파라미터가 없는 기본 생성자를 생성한다.

@Id
PK를 지정하기 위해 @Id를 사용.

@GeneratedValue
@Id와 함께 사용된다. 생성 전략을 정의하기 위해 @GeneratedValue를 사용한다.
@GeneratedValue(strategy = GenerationType.IDENTITY) >> 기본키 생성을 데이터베이스에게 위임하는 방식으로 id값을 따로 할당하지 않아도 데이터베이스가 자동으로 AUTO_INCREMENT를 하여 기본키를 생성.

@Column
객체 필드를 테이블 컬럼에 매핑한다.

### PostsRepository



### BaseTimeEntity






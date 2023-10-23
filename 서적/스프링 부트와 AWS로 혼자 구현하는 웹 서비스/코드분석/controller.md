### **IndexController**

private final PostsService postsService;
PostsService 타입의 멤버 변수를 생성해줌으로써 postsService 변수를 이용해 PostsService 클래스 메서드에 접근할 수 있다. 
컨트롤러는 보통 Service의 의존성을 주입받는다? IndexController, PostsApiController

@RequiredArgsConstructor
초기화 되지 않은 final 필드나, @NonNull이 붙은 필드에 대해 생성자를 생성한다.
의존성 주입의 편의성을 위해 사용된다. 
새로운 필드를 추가할 때 다시 생성자를 만들어서 관리해야 하는 번거러움을 없애준다.

@Controller
Spring MVC의 Controller로 사용되는 클래스를 의미한다.

@GetMapping
@GetMapping은 @RequestMapping(Method=RequestMethod.GET)과 같다. 
@PostMapping, @PutMapping, @PatchMapping, @DeleteMapping 등도 있다.

@RequestMapping
요청 URL을 어떤 method가 처리할 지 mapping 해주는 어노테이션이다.

Model 객체
Controller에서 생성한 데이터를 담아서 View로 전달할 때 사용하는 객체.
Servlet의 request.setAttribute()와 비슷한 역할을 한다.
addAttritube("key", "value") 메서드를 이용해 view에 전달할 데이터를 key, value 형식으로 전달 할 수 있다.

@PathVariable
https://byul91oh.tistory.com/435

REST API에서 URI에 변수가 들어가는 것을 볼 수 있다.
예) http://localhost:8080/api/user/1234 -> 1234가 변수에 해당.
1234와 같은 변수 부분은 @PathVariable로 처리를 할 수 있다.

사용 방법
![[Pasted image 20231004193602.png]]
```
@GetMapping("/posts/update/{id}")  
public String postsUpdate(@PathVariable Long id, Model model) {  
    PostsResponseDto dto = postsService.findById(id);  
    model.addAttribute("post", dto);  
  
    return "posts-update";  
}
```


### **PostsApiController**

PostsApiController의 필요성? HTTP body 내용을 json 형태로 전달해야 하는 이유?

@RestController
@RestController는 @Controller에 @ResponseBody가 추가된 것이다. 
@RestController의 주 용도는 Json 형태로 객체 데이터를 반환하는 것이다.

@RequestBody
https://cheershennah.tistory.com/179

스프링에서 비동기 처리를 하는 경우 @RequestBody, @ResponseBody를 사용.

웹에서 화면전환(새로고침) 없이 이루어지는 동작들은 대부분 비동기 통신으로 이루어진다.
비동기 통신을 하기 위해서는 클라이언트에서 서버로 요청 메시지를 보낼 때 본문에 데이터를 담아서 보내야 하고, 서버에서 클라이언트로 응답을 보낼 때에도 본문에 데이터를 담아서 보내야 한다.
이 본문이 바로 body이다. 본문이 담기는 데이터 형식은 주로 JSON이다.

@RequestBody와 @ResponseBody가 HTTP 요청 바디를 객체로 변환하고 자바 객체를 다시 HTTP 응답 바디로 변환해준다. 

일반적인 GET/POST의 파라미터라면 @RequestBody를 사용할 일이 없지만 xml이나 json 기반의 메시지를 사용하는 요청의 경우 이 방법이 유용하다. http 요청의 바디 내용을 통째로 자바 객체로 변환하여 매핑된 메소드 파라미터로 전달한다.

정리
클라이언트에서 서버로 필요한 데이터를 요청하기 위해 JSON 데이터를 요청 본문에 담아서 서버로 보내면, 서버에서는 @RequestBody를 사용하여 http 본문에 담긴 값을 자바객체로 변환시켜 객체에 저장한다.
서버에서는 클라이언트로 응답 데이터를 전송하기 위해 @ResponseBody를 사용하여 자바 객체를 http 응답 본문으로 변환하여 클리이언트로 전송한다. 



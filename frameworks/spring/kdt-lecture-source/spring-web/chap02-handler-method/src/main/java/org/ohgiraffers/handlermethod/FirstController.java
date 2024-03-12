package org.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@RequestMapping("/first/*")
@SessionAttributes("id")
public class FirstController {

    /* 핸들러 메서드의 반환 값을 void로 설정하면 요청 주소가 곧 view의 이름이 된다.
    * => /first/regist 뷰를 응답한다. */
    @GetMapping("/regist")
    public void regist() {}

    /* 핸들러 메서드에 파라미터로 특정 몇 가지 타입을 선언하게 되면 핸들러 메서드 호출 시 인자로 값을 전달해준다.  */

    /* 1. WebRequest로 요청 파라미터 전달 받기
    * HttpServletRequest/Response, ServletRequest/Response도 핸들러 메서드 매개변수로 사용 가능하지만,
    * 단, WebRequest가 Servlet에 종속적이지 않으므로 Spring 기반의 프로젝트에서 더 자주 사용 된다. */
    @PostMapping("/regist")
    public String registMenu(WebRequest webRequest, Model model) {

        /* WebRequest 객체의 getParameter 메서드를 이용해 클라이언트에서 전달된 파라미터를 가져올 수 있다. */
        String name = webRequest.getParameter("name");
        int price = Integer.parseInt(webRequest.getParameter("price"));
        int categoryCode = Integer.parseInt(webRequest.getParameter("categoryCode"));

        String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("/modify")
    public void modify() {}

    /* 2. @RequestParam으로 요청 파라미터 전달 받기
    * WebRequest 객체의 getParameter 메서드를 사용할 필요 없이
    * 요청 파라미터를 매핑하여 핸들러 메서드 호출 시 값을 넣어주는 어노테이션으로 매개변수 앞에 작성한다.
    * name 속성과 매개변수명이 다른 경우 @RequestParam("name")을 설정한다.
    * 또한 어노테이션 생략도 가능하다.
    *
    * 전달하는 name 속성과 일치하는 것이 없는 경우 400 에러가 발생하는데 이는 required 속성의 기본값이 true이기 때문이다.
    * 해당 속성을 false로 변경하면 값이 존재하지 않아도 null 처리된다.
    *
    * 값을 입력하지 않게 되면 "" 빈 문자열이 넘어오는데 이 때 parsing 관련 에러가 발생할 수 있다.
    * defaultValue 속성을 이용하면 기본 값 설정이 가능하다.
    * */
    @PostMapping("/modify")
    public String modifyMenu(
            @RequestParam (value="name", required = false) String modifyMenu,
            @RequestParam (value = "price", defaultValue = "0") int modifyPrice,
            Model model
    ) {

        String message = modifyMenu + " 메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    /* 파라미터가 여러개인 경우 Map으로 한 번에 처리할 수 있다. 맵의 키는 name 속성이 된다. */
    @PostMapping("/modifyAll")
    public String modifyAll(@RequestParam Map<String, String> parameters, Model model) {

        String modifyMenu = parameters.get("name");
        String modifyPrice = parameters.get("price");

        String message = modifyMenu + " 메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("/search")
    public void search() {}

    /* 3. @ModelAttribute를 이용하는 방법
    * DTO 같은 모델을 커맨드 객체로 전달 받는 어노테이션이다. 해당 객체가 model에 담기는 작업도 자동으로 일어난다.
    * @ModelAttribute("모델에 담을 key")와 같이 지정할 수 있으며 지정하지 않으면 타입의 앞글자를 소문자로 한 네이밍 교칙을 따른다.
    * 어노테이션을 생략하는 것도 가능하다.
    * */
    @PostMapping("/search")
    public String searchMenu(@ModelAttribute("menu") MenuDTO menu) {

        return "first/searchResult";
    }

    @GetMapping("/login")
    public void login(){}

    /* 4-1. HttpSession 사용 */
    @PostMapping("/login1")
    public String sessionTest1(String id, HttpSession session) {

        session.setAttribute("id", id);

        return "first/loginResult";
    }

    @GetMapping("/logout1")
    public String logoutTest1(HttpSession session) {
        session.invalidate();

        return "first/loginResult";
    }

    /* 4-2. @SessionAttributes
    * HttpSession은 Servlet에 종송적이므로 Spring에서 제공하는 기능으로 변경해본다.
    * 클래스 레벨에 @SessionAttributes 어노테이션을 이용하여 세션에 값을 담을 key를 설정해두면
    * Model 영역에 해당 key가 추가 될 때 session에 자동 등록 된다.
    * */

    @PostMapping("/login2")
    public String sessionTest2(String id, Model model){

        model.addAttribute("id", id);

        return "first/loginResult";
    }

    /* @SessionAttributes로 등록된 값은 SessionStatus(세션의 상태를 관리하는 객체)의
    * setComplete() 메서드를 호출해야 사용이 만료 된다.
    * */
    @GetMapping("/logout2")
    public String logoutTest2(SessionStatus sessionStatus) {
        sessionStatus.setComplete();

        return "first/loginResult";
    }

    @GetMapping("/body")
    public void body(){}

    /* 5. @RequestBody
    HTTP 메세지의 본문 자체를 모델로 변환시켜주는 어노테이션이다.
    String 타입으로 처리하면 쿼리 스트링 형태의 문자열을 확인할 수 있고
    JSON으로 전달하는 경우 Jackson converter로 자동 파싱하여 사용할 수 있다.
    * */
    @PostMapping("/body")
    public void bodyTest(
            @RequestBody String body,
            @RequestHeader("content-type") String contentType,
            @CookieValue("JSESSIONID") String sessionId
    ) {
        System.out.println("body : " + body);
        System.out.println("contentType : " + contentType);
        System.out.println("sessionId : " + sessionId);
    }
}

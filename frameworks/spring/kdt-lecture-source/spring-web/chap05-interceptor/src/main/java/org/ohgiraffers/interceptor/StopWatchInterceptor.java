package org.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/* HandlerInterceptor 인터페이스를 구현해서 작성해야 함 */
@Component
public class StopWatchInterceptor implements HandlerInterceptor {

    /* Interceptor는 스프링 컨테이너에 존재하는 빈을 의존성 주입 받을 수 잇다. */
     private final MenuService menuService;

     // @Autowired 어노테이션이 생략
    public StopWatchInterceptor(MenuService menuService) {
        this.menuService = menuService;
    }


    /* 전처리 메서드 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler 메서드 호출함");

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        /* true를 반환하면 컨트롤러 핸들러 메서드의 호출로 이어지고 false를 반환하면 호출하지 않음 */
        return true;
    }

    /* 후처리 메서드 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler 호출함");

        long endTime = System.currentTimeMillis();
        long startTime = (Long) request.getAttribute("startTime");

        modelAndView.addObject("interval", endTime - startTime);
    }

    /* 뷰가 렌더링 된 이후 동작하는 메서드 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 호출함");
        menuService.method();
    }
}

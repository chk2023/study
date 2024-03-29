package org.ohgiraffers.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final StopWatchInterceptor stopWatchInterceptor;

    // @Autowired 어노테이션이 생략
    public WebConfiguration(StopWatchInterceptor stopWatchInterceptor) {
        this.stopWatchInterceptor = stopWatchInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /* 인터셉터 등록 */
        registry.addInterceptor(stopWatchInterceptor).addPathPatterns("/stopwatch");
    }
}

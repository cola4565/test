package com.wsq.test02.config;

import com.wsq.test02.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//定义此类为配置类
public class ConfigInterceptor implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] add= {"/center","/newpassword","/changepassword","/deletes"};
        registry.addInterceptor(new UserInterceptor()).addPathPatterns(add);
    }
}

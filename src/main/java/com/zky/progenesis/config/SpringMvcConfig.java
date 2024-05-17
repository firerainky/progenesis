package com.zky.progenesis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zky.progenesis.interceptor.NewInterceptor;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new NewInterceptor())
                .addPathPatterns("/**")
                .order(-10);
    }
}

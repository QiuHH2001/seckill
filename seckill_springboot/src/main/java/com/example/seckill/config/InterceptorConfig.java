package com.example.seckill.config;

import com.example.seckill.config.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：qhh
 * @date ：Created in 2022/6/4 0:21
 */
@Configuration
@Component
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/product/add",
                        "/product/delete",
                        "/admin/**",
                        "/product/seckillTest",
                        "/user/register",
                        "/user/login",
                        "/swagger-resources/**",
                        "/swagger-ui/**",
                        "/v3/**",
                        "/error");
    }

    @Bean
    public JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }
}

//package org.hx.controller;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
///**
//* <p>Title: MyWebMvcConfigurer</p>  
//* <p>Description: 配置拦截器</p>  
//* @author hx  
//* @date 2018年8月7日
// */
//@Configuration
//public class MyWebMvcConfigurer extends WebMvcConfigurationSupport{
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authenticationInterceptor())
//                .addPathPatterns("/**");    // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
//        super.addInterceptors(registry);
//    }
//
//    @Bean
//    public AuthenticationInterceptor authenticationInterceptor() {
//        return new AuthenticationInterceptor();
//    }
//
//}

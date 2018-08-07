//package org.hx.controller;
//
//import java.lang.reflect.Method;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.hx.controller.annotation.LoginRequired;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
///**
//* <p>Title: AuthenticationInterceptor</p>  
//* <p>Description: 创建拦截器</p>  
//* @author hx  
//* @date 2018年8月7日
// */
//public class AuthenticationInterceptor implements HandlerInterceptor{
//
//    public boolean preHandle(HttpServletRequest request,
//            HttpServletResponse response, Object handler) throws Exception {
//        
//        System.out.println(">>>>>>>>>>进入拦截器");
//        // 如果不是映射到方法直接通过
//        if (!(handler instanceof HandlerMethod)) {
//            return true;
//        }
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        Method method = handlerMethod.getMethod();
//
//        // 判断接口是否需要登录
//        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
//        // 有 @LoginRequired 注解，需要认证
//        if (methodAnnotation != null) {
//            // 执行认证
//            String token = request.getHeader("token");  // 从 http 请求头中取出 token
//            if (token == null) {
//                throw new RuntimeException("无token，请重新登录");
//            }
//            
//            System.out.println("》》》》》》》》》》》》验证token");
//            request.setAttribute("currentUser", "user");
//            return true;
//        }
//        return true;
//    }
//}
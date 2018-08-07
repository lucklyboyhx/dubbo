package org.hx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
@Component
public class AccessAuthHandle {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Value("${session.SessionIdName}")
    private String sessionIdName;
    
    /** 定义切点 */
    @Pointcut("execution(public * org.hx.controller.user..*.*(..))")
    public void accessAuth(){}

    /**
     * 拦截所有请求
     */
    @Before("accessAuth()")
    public void doBefore() {

        // 访问鉴权
        authentication();

    }
    
    private void authentication() {
        System.out.println("进入切面>>>>>>>>>>>>");
     // 获取 HttpServletRequest
        HttpServletRequest request = getHttpServletRequest();
        String url = request.getServletPath();
        
     // 获取 SessionID
        String sessionID = getSessionID(request);
        
        System.out.println("根据sessionId获取用户：" + sessionID);
        
        System.out.println("根据url获取方法权限" + url);
    }
    
    /**
     * 获取HttpServletRequest
     * @return
     */
    private HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        return servletRequestAttributes.getRequest();
    }
    
    /**
     * 获取SessionID
     * @param request 当前的请求对象
     * @return SessionID的值
     */
    private String getSessionID(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        // 遍历所有cookie，找出SessionID
        String sessionID = null;
        if (cookies!=null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                if (sessionIdName.equals(cookie.getName())) {
                    sessionID = cookie.getValue();
                    break;
                }
            }
        }

        return sessionID;
    }
}

package org.hx.controller;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogHandle {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * org.hx.controller.user..*.*(..))")
    public void restLog(){}
    
    @Around("restLog()")
    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("日志拦截>>>>>>>>>>>");
     // 生成本次请求时间戳
        String timestamp = System.currentTimeMillis()+"";

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        System.out.println("日志拦截信息：" + "url>>" + url + "method>>" + method + "uri>>" + uri + "queryString>>" + queryString);
        logger.info(timestamp + ", url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);

        // result的值就是被拦截方法的返回值
        Object result = joinPoint.proceed();
        System.out.println("日志拦截返回：" + timestamp + "<<<" + result.toString());
        logger.info(timestamp + " , " + result.toString());
    }
}

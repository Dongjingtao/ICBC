package com.icbc.sh.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 交易切面.
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

//    @Pointcut("execution(public * com.icbc.sh.controller2.*.*(..))")//两个..代表所有子目录，最后括号里的两个..代表所有参数
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)") //表示所有使用了@RestController注解的方法
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("请求地址: " + request.getRequestURI());
        log.info("HTTP METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());


    }

    @AfterReturning(returning = "ret", pointcut = "logPointCut()")// returning的值和doAfterReturning的参数名一致
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        log.info("返回值 : " + ret);

    }


}

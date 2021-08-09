package com.tml.mouseDemo.aop;

import com.tml.mouseDemo.core.annotation.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class MethodAspectJ {

    /**
     * 前置通知
     */
    @Before("execution(* com.tml.mouseDemo.service.impl.UserServiceImpl.*(..))")
    public void beforeAdvice() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("request:{}", request);
        log.info("beforeAdvice success!");

    }


    @After("@annotation(com.tml.mouseDemo.core.annotation.SystemLog)")
    public void afterAdvice() {
        log.info("afterAdvice success!");
    }

    @Around("execution(* com.tml.mouseDemo.service.impl.*.*(..)) &&@annotation(systemLog) && args(num,price)")
    public Object aroudAdvice(ProceedingJoinPoint joinPoint, SystemLog systemLog, long num, double price) throws Throwable {
        log.info("aroudAdvice enter!");
        Object[] args = joinPoint.getArgs();
        log.info("argus:{}", Arrays.deepToString(args));

        String type = systemLog.type();
        log.info("annotationType:{}", type);

        Object proceed = joinPoint.proceed();

        return num * price;

    }

}

package com.tml.mouseDemo.config;

import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class TraceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = UUID.fastUUID().toString(true);
        log.info("TraceInterceptor preHandle,generate traceId is:{}", traceId);
        TraceContext.set(traceId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("TraceInterceptor afterCompletion,ready to clean traceId:{}", TraceContext.get());
        TraceContext.clean();
    }
}

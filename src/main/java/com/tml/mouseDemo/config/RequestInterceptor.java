package com.tml.mouseDemo.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.tml.mouseDemo.constants.CommonConstants.LANGUAGE_CODE;

@Slf4j
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String language = request.getHeader(LANGUAGE_CODE);
        log.info("RequestInterceptor preHandle,request language is {}", language);
        LanguageContext.set(language);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("RequestInterceptor afterCompletion,request language is {},ready to clean data!", LanguageContext.get());
        LanguageContext.clean();
    }
}
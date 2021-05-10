package com.tml.mouseDemo.exception;

import com.google.gson.Gson;
import com.tml.mouseDemo.constants.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private Gson gson;

    @ExceptionHandler
    public String exceptionHandle(Exception e) {
        log.error("GlobalExceptionHandler error", e);
        return gson.toJson(CommonResponse.fail());
    }

}

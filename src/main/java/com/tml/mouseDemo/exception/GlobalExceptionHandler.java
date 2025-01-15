package com.tml.mouseDemo.exception;

import com.tml.mouseDemo.constants.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public CommonResponse exceptionHandle(Exception e) {
        log.error("GlobalExceptionHandler error", e);
        return CommonResponse.fail(e.getMessage());
    }

}

package com.tml.mouseDemo.core.threadLocalDemo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);

        } catch (Exception e) {

        }

    }

    public static void printLog(String message){
        log.info(message);
    }
}

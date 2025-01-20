package com.tml.mouseDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TraceService {

    public void trace(String type) throws InterruptedException {
        log.info("trace start,type:{}", type);
        Thread.sleep(1000L);
        log.info("trace end");
    }
}

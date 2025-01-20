package com.tml.mouseDemo.controller;

import com.tml.mouseDemo.constants.CommonResponse;
import com.tml.mouseDemo.service.TraceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@Slf4j
public class TraceController {
    @Autowired
    private ThreadPoolExecutor executor;

    @Autowired
    private Executor ttlExecutor;

    @Autowired
    private TraceService traceService;


    @PostMapping("/trace")
    public CommonResponse<String> trace(String type) throws InterruptedException {
        log.info("trace type:{}", type);
        traceService.trace(type);
        return CommonResponse.success("success");
    }

    @PostMapping("/traceWithThread")
    public CommonResponse<String> traceWithThread(String type) throws InterruptedException {
        log.info("traceWithThread type:{}", type);
        traceService.trace(type);

        //模拟异步发短信
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                String sendMsg = "hello world";
                log.info("sendMsg:{}", sendMsg);

            } catch (Exception e) {
                log.error("traceWithThread occur error", e);
            }

        }, "trace--001").start();

        return CommonResponse.success("success");
    }

    @PostMapping("/traceWithThreadPool")
    public CommonResponse<String> traceWithThreadPool(String type) throws InterruptedException {
        log.info("traceWithThreadPool type:{}", type);
        traceService.trace(type);
        //模拟异步发短信
        executor.execute(() -> {
            try {
                Thread.sleep(2000);
                String sendMsg = "hello world";
                log.info("sendMsg:{}", sendMsg);

            } catch (Exception e) {
                log.error("traceWithThreadPool occur error", e);
            }
        });

        //模拟异步发短信
        ttlExecutor.execute(() -> {
            try {
                Thread.sleep(2000);
                String sendMsg = "hello world";
                log.info("sendMsg:{}", sendMsg);

            } catch (Exception e) {
                log.error("traceWithThreadPool occur error", e);
            }
        });


        return CommonResponse.success("success");
    }
}

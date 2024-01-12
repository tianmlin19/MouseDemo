package com.tml.mouseDemo.service.impl;

import com.tml.mouseDemo.config.CustomThreadPoolExecutor;
import com.tml.mouseDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private ThreadPoolExecutor executor;

    @Autowired
    private ThreadPoolExecutor uncaughtExceptionExecutor;

    @Autowired
    private CustomThreadPoolExecutor customExecutor;

    @Override
    public void customExecutor() throws InterruptedException {
        int count = 10;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            customExecutor.execute(() -> {
                String str = "customExecutor";
                log.info("customExecutor str:{}", str);

                int length = str.length();

                countDownLatch.countDown();

            });

        }

        countDownLatch.await();

        log.info("concurrent execute finished!");
    }

    @Override
    public void executorSubmitTest() throws ExecutionException, InterruptedException {

        uncaughtExceptionExecutor.execute(() -> {
            String str = null;
            log.info("execute str:{}", str);

            int length = str.length();
        });

        /*Future<Integer> submit = uncaughtExceptionExecutor.submit(() -> {
            String str = null;
            log.info("execute str:{}", str);

            int length = str.length();

            return length;
        });


        try {
            Integer integer = submit.get();
            log.info("concurrent result:{}", integer);
        } catch (Exception e) {
            log.error("occur error", e);
        }*/


    }

    @Override
    public void executorLogTest() throws Exception {
        int count = 10;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            executor.execute(() -> {
                String str = null;
                log.info("execute str:{}", str);

                int length = str.length();
            });
        }

        countDownLatch.await();

        log.info("concurrent execute finished!");
    }


    @Override
    public String printUser(String userName, String value) {
        log.info("UserService printUser！");

        return userName + value;
    }
}

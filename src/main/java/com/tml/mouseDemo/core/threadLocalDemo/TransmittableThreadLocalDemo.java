package com.tml.mouseDemo.core.threadLocalDemo;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import com.alibaba.ttl.threadpool.agent.internal.transformlet.impl.TtlExecutorTransformlet;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransmittableThreadLocalDemo {

    private static ThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();

    private static ExecutorService service = Executors.newFixedThreadPool(2, new SimpleThreadFactory());

    private static Executor ttlExecutor = TtlExecutors.getTtlExecutor(service);


    public static void main(String[] args) throws InterruptedException {




        threadLocal.set("hello main");
        for (int i = 0; i < 2; i++) {
            ttlExecutor.execute(() -> {
                String s = threadLocal.get();
                ThreadUtils.printLog("get data " + s);

            });
        }

        //修改threadLocal中的值
        threadLocal.set("hello world");
        Thread.sleep(2000);
        for (int i = 0; i < 2; i++) {

            ttlExecutor.execute(() -> {
                String s = threadLocal.get();
                ThreadUtils.printLog("get data " + s);

            });
        }


        ThreadUtils.printLog("get data " + threadLocal.get());

        service.shutdown();

    }
}

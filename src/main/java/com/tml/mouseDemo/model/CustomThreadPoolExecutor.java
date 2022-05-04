package com.tml.mouseDemo.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.*;

@Slf4j
public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    public CustomThreadPoolExecutor(int corePoolSize,
                                    int maximumPoolSize,
                                    long keepAliveTime,
                                    TimeUnit unit,
                                    BlockingQueue<Runnable> workQueue,
                                    ThreadFactory threadFactory,
                                    RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        if (Objects.nonNull(t)) {
            log.error("CustomThreadPoolExecutor occur error", t);
        } else {
            log.info("CustomThreadPoolExecutor execute success!");
        }


    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        //线程池基础数据采集
        int corePoolSize = this.getCorePoolSize();
        int activeCount = this.getActiveCount();
        long completedTaskCount = this.getCompletedTaskCount();
        int size = this.getQueue().size();
        int maximumPoolSize = this.getMaximumPoolSize();

        log.info("CustomThreadPoolExecutor corePoolSize：{}--activeCount：" +
                "{}--completedTaskCount:{}--queueSize：{}--maximumPoolSize:{}", corePoolSize, activeCount, completedTaskCount, size, maximumPoolSize
        );


    }


}

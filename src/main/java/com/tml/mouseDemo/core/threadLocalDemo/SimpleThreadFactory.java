package com.tml.mouseDemo.core.threadLocalDemo;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleThreadFactory implements ThreadFactory {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    @Override
    public Thread newThread(Runnable r) {

        Thread t = new Thread(r);
        t.setName("tml-"+atomicInteger.getAndIncrement());
        return t;
    }
}

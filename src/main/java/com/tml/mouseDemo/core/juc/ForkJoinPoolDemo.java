package com.tml.mouseDemo.core.juc;

import org.apache.tomcat.util.net.AbstractEndpoint;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(1, 10000);
        ForkJoinTask<Long> submit = pool.submit(task);

        System.out.println(submit.get());


    }
}

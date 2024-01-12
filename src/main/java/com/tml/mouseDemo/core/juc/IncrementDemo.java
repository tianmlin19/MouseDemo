package com.tml.mouseDemo.core.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class IncrementDemo {

    private static long count1 = 0;

    private static AtomicLong count2 = new AtomicLong(0);

    private static LongAdder count3 = new LongAdder();

    private static Object lock = new Object();

    private static final int Thread_count = 1000;

    private static final int loop_count = 10000;


    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < Thread_count; i++) {
            Thread thread = new Thread(() -> {
                synchronized (lock) {
                    for (int k = 0; k < loop_count; k++) {
                        count1++;
                    }
                }
            });

            threads.add(thread);
        }

        long start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("sync耗时：" + (end - start) + "毫秒--count1：" + count1);

        List<Thread> threads1 = new ArrayList<>();
        for (int i = 0; i < Thread_count; i++) {
            Thread thread = new Thread(() -> {
                for (int k = 0; k < loop_count; k++) {
                    count2.incrementAndGet();
                }
            });

            threads1.add(thread);
        }

        long start1 = System.currentTimeMillis();
        for (Thread thread : threads1) {
            thread.start();
        }
        for (Thread thread : threads1) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end1 = System.currentTimeMillis();
        System.out.println("AtomicLong耗时：" + (end1 - start1) + "毫秒--count2：" + count2.get());


        List<Thread> threads2 = new ArrayList<>();
        for (int i = 0; i < Thread_count; i++) {
            Thread thread = new Thread(() -> {
                for (int k = 0; k < loop_count; k++) {
                    count3.increment();
                }
            });

            threads2.add(thread);
        }

        long start2 = System.currentTimeMillis();
        for (Thread thread : threads2) {
            thread.start();
        }
        for (Thread thread : threads2) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end2 = System.currentTimeMillis();
        System.out.println("LongAdder耗时：" + (end2 - start2) + "毫秒--count3：" + count3.longValue());

    }


}

package com.tml.mouseDemo.core.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * ReentrantLock和synchronized功能一样
 * 但是ReentrantLock更加强大
 * 1.ReentrantLock在竞争锁的时候，可以tryLock，即尝试加锁锁，也就是加锁这个操作可以交给用户来处理
 * 2.ReentrantLock在竞争锁的时候可以使用lockInterruptibly()来打断,而synchronized必须调用notify才行
 */
public class ReentrantLockDemo {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                lock.lock();
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });


        Thread thread2 = new Thread(() -> {
            try {
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hhhhhh");

            } finally {
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();
        thread2.interrupt();
    }
}

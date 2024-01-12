package com.tml.mouseDemo.core.juc;

public class LockDemo {

    private static String lock1 = new String("hello");
    private static String lock2 = new String("hello");

    public static void main(String[] args) {
        LockDemo demo = new LockDemo();
        new Thread(() -> {
            try {
                demo.m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                demo.m2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    void m1() throws InterruptedException {
        synchronized (lock1) {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
        }
    }

    void m2() throws InterruptedException {
        synchronized (lock2) {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
        }
    }
}

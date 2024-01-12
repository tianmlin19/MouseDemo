package com.tml.mouseDemo.core.juc;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReetLockDemo {

    static volatile int a;

    public static void readA() {
        System.out.println("readA" + a);

    }

    public static void writeA() {
        a++;
        System.out.println(a);
    }

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        Thread read1 = new Thread(() -> {
            readLock.lock();

            try {
                readA();
            } finally {
                readLock.unlock();
            }

        });

        Thread read2 = new Thread(() -> {
            readLock.lock();

            try {
                readA();
            } finally {
                readLock.unlock();
            }
        });


        Thread write = new Thread(() -> {
            writeLock.lock();

            try {
                writeA();
            } finally {
                writeLock.unlock();
            }
        });


        read1.start();
        read2.start();
        write.start();
    }


}

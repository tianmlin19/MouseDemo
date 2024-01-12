package com.tml.mouseDemo.core.juc;

import java.io.IOException;
import java.util.concurrent.locks.LockSupport;


/**
 * 模拟两个线程分别输出
 */
public class PrintDemo {

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) throws IOException {


        t1 = new Thread(() -> {
            char[] chars = "123456".toCharArray();
            for (char c : chars) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();

            }
        }, "t1");


        t2 = new Thread(() -> {
            char[] chars = "ABCDEF".toCharArray();
            for (char c : chars) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);


            }
        }, "t2");


        t1.start();
        t2.start();


        //System.in.read();
    }
}

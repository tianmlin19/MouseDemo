package com.tml.mouseDemo.core.jvm;


public class DisOrder {
    static volatile int a;
    static int b;
    static int y;
    static int x;


    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        while (true) {
            a = 0;
            b = 0;
            y = 0;
            x = 0;

            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            count++;

            if (x == 0 && y == 0) {
                System.out.println("程序发生了指令重排，第" + count + "次");
                break;
            }
        }
    }
}
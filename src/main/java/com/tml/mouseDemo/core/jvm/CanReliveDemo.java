package com.tml.mouseDemo.core.jvm;

public class CanReliveDemo {

    private static CanReliveDemo obj;


    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        obj = this;
    }

    public static void main(String[] args) throws InterruptedException {

        obj = new CanReliveDemo();

        obj = null;

        //主动触发gc
        System.gc();
        System.out.println("第一次gc");

        Thread.sleep(1000);

        if (obj == null) {
            System.out.println("obj is dead!");
        } else {
            System.out.println("obj is still alive!");
        }

        obj = null;
        System.gc();
        System.out.println("第二次gc");

        Thread.sleep(1000);

        if (obj == null) {
            System.out.println("obj is dead!");
        } else {
            System.out.println("obj is still alive!");
        }

    }
}

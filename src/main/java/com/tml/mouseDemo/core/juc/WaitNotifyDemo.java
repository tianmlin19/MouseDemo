package com.tml.mouseDemo.core.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotifyDemo {

    private List<Integer> list = new ArrayList<>();

    public void add(Integer integer) {
        list.add(integer);
    }

    public int getSize() {
        return list.size();
    }

    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) throws InterruptedException {
        WaitNotifyDemo demo = new WaitNotifyDemo();

        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
                demo.add(i);
                System.out.println("add num\t" + i);
            }

        }, "t1");


        t2 = new Thread(() -> {
            LockSupport.park();
            System.out.println("t2 end");
            LockSupport.unpark(t1);


        }, "t2");

        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t1.start();
    }

    /*public static void main(String[] args) throws InterruptedException {
        WaitNotifyDemo demo = new WaitNotifyDemo();
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    countDownLatch1.countDown();//释放门栓，让t2可以执行
                    try {
                        countDownLatch2.await();//同时自己等待t2完成，释放门栓
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                demo.add(i);
                System.out.println("add num\t" + i);
            }

        }, "t1");


        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    countDownLatch1.await();//等待t1释放了门栓了
                    System.out.println("t2 end");
                    break;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch2.countDown();//释放门栓，让t1继续执行
                }
            }


        }, "t2");

        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t1.start();
    }*/

    /*public static void main(String[] args) throws InterruptedException {
        WaitNotifyDemo demo = new WaitNotifyDemo();

        final Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    if (i == 5) {
                        lock.notify();//唤醒t2,但是notify是不释放锁资源的，他需要将剩下的逻辑执行完毕
                        try {
                            lock.wait();//t1线程自己睡眠，同时让出锁资源
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    demo.add(i);
                    System.out.println("add num\t" + i);
                }
            }

        }, "t1");


        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                while (true) {
                    if (demo.getSize() != 5) {
                        try {
                            lock.wait();//释放锁资源，进入一个队列等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("t2 end");
                        break;
                    }
                }

                lock.notify();//唤醒加在lock上的线程，让其进入到就绪队列
            }


        }, "t2");

        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t1.start();
    }*/
}

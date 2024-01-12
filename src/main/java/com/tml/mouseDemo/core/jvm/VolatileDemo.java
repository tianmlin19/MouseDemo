package com.tml.mouseDemo.core.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * volatile用于保持线程的可见性
 * <p>
 * 默认情况下，一个线程对一个共享变量的修改，另外一个线程是不可见的
 * 若想修改以后，另外一个线程就可见，需要使用关键字volatile修饰成员共享变量
 * <p>
 * volatile 修饰引用类型【包括数组】，只能保证引用本身的可见性，不能保证内部字段的可见性，一般volatile不会修饰引用类型
 *
 * 另外volatile不能保证原子性，而synchronized是可以保证原子性、可见性的，但是不能保证有序性
 *
 *
 */
public class VolatileDemo {

    private static volatile Boolean running = true;

    private static volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> n());
            threads.add(thread);
        }

        //启动线程
        threads.stream().forEach(t ->
                t.start());

        //线程join进来
        threads.stream().forEach(t ->
        {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        System.out.println(num);


        /*new Thread(VolatileDemo::m, "t1").start();

        TimeUnit.SECONDS.sleep(1);

        running = false;*/

    }

    private static void n(){
        for (int i = 0; i < 10000; i++) {
            num++;
        }
    }
    private static void m() {
        System.out.println("m start!");
        while (running) {

        }
        System.out.println("m end!");
    }
}

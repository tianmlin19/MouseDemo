package com.tml.mouseDemo.core.jvm;


/**
 * -Xmx100M -Xms100M -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 */
public class StackAllocation {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();



        System.out.println("耗时：" + (end - begin)+"毫秒！");
    }

    /*
    user对象没有发生逃逸
     */
    private static void alloc() {
        User user = new User();
    }

    static class User {

    }
}


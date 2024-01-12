package com.tml.mouseDemo.core.jvm;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    public static void main(String[] args) throws InterruptedException {

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        /* scheduledThreadPoolExecutor.schedule(() -> System.out.println(new Date()), 2, TimeUnit.SECONDS);*/

        /*scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
                    System.out.println(new Date());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },
                2, 2, TimeUnit.SECONDS);*/


        scheduledThreadPoolExecutor.scheduleWithFixedDelay(() -> {
                    System.out.println(new Date());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },
                2, 2, TimeUnit.SECONDS);



        /*String binaryString = Integer.toBinaryString(-1 << 3);
        String binaryString1 = Integer.toBinaryString(0 << 3);
        String binaryString2 = Integer.toBinaryString(1 << 3);
        String binaryString3 = Integer.toBinaryString(2 << 3);
        System.out.println(binaryString);
        System.out.println(binaryString1);
        System.out.println(binaryString2);
        System.out.println(binaryString3);*/

       /* String regex = "^(a+)+$";
        String regex1 = "(a|aa)+";
        String targetStr = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaX";
        Pattern compile = Pattern.compile(regex1);
        boolean matches = compile.matcher(targetStr).matches();
        System.out.println(matches);*/

        /**
         * 使用正则表达式需要注意
         * 1.降低正则表达式的复杂度，尽量少用分组
         * 2.严格限制用户输入的字符串的长度
         * 3.常见的有缺陷的正则表达式参考
         * (a+)+
         * ([a-zA-Z]+)*
         * (a|aa)+
         */
    }

    public static void test(Object object) {
        if (object == null) {
            return;
        }

        if (object instanceof Integer) {
            int res = (Integer) object;
            res++;

            System.out.println(res);
        }

        if (object instanceof String) {
            String res = (String) object;
            System.out.println("hello ljf " + res);
        }
    }
}

package com.tml.mouseDemo.core;

import java.util.concurrent.ExecutionException;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {


        System.out.println(isPrime(9));
        /*ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(()->{
            System.out.println(1);
            int a = 1 / 0;
        });

        executorService.execute(()->{
            System.out.println(1);
            int a = 1 / 0;
        });
        int a = -5;*/

        /*System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a << 2));
        System.out.println(Integer.toBinaryString(a >> 2));
        System.out.println(Integer.toBinaryString(a >>> 2));*/

        /*ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<Integer> callable1 = () -> {
            try {
                Thread.sleep(1000);
                System.out.println(1);
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        };

        Callable<Integer> callable2 = () -> {
            System.out.println(2);
            return 2;
        };

        ArrayList<Callable<Integer>> callables = Lists.newArrayList(callable1, callable2);
        Integer i = executorService.invokeAny(callables);

        System.out.println("result:" + i);

        executorService.shutdown();*/

    }

    public static void p() {
        for (int i = 3; i < 1000000; i++) {
            isPrime(i);
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

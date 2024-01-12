package com.tml.mouseDemo.core.juc;

import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static cn.hutool.core.date.DatePattern.NORM_DATETIME_MS_FORMAT;

public class CompletableFutureDemo {

    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<String>[] completableFutures = new CompletableFuture[10];
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            completableFutures[i] = CompletableFuture.supplyAsync(() -> {
                SleepWork(200);
                return "thread " + finalI + "execute ok";
            });
        }
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);

        CompletableFuture<String> completableFuture = voidCompletableFuture.thenApply(result -> {
            System.out.println(result);
            return "all threads finished";
        });

        System.out.println(completableFuture.join());
    }

    /**
     * applyToEither表示两个异步任务，只要完成其中一个就行了
     * exceptionally可以针对异常进行处理，入参是一个Function
     */
    public static void demo4() {
        print("张三正在等公交车");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            int i = random.nextInt(1000) + 1;
            SleepWork(i);
            return "788";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            int i = random.nextInt(1000) + 1;
            SleepWork(i);
            return "709";
        }), bus -> {

            if (bus.equals("788")) {
                throw new RuntimeException("788今日人满为患，暂时不提供服务~");
            }

            return "武汉公交车" + bus;
        }).exceptionally(throwable -> {
            //throwable.printStackTrace();
            return "呼叫滴滴打车";
        });

        System.out.println(completableFuture.join() + "\t准备回家~");
    }

    /**
     * thenCombine的第一个参数是CompletableFuture，他和第一个任务是并行的，第二个参数是一个BiFunction，第三个任务是依赖前两个任务的结果
     */
    public static void demo3() {
        print("小白进入餐厅！");
        print("小白点了番茄炒蛋和一份米饭~");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            print("厨师开始炒菜了~");
            SleepWork(600);
            return "番茄炒蛋";
        }).thenCombineAsync(CompletableFuture.supplyAsync(() -> {
            print("服务员开始蒸米饭了~");
            SleepWork(600);
            return "米饭";
        }), (dish, rice) -> {
            print("服务员打饭");
            SleepWork(100);
            return dish + "\t" + rice + "\t 准备好了";
        });

        print(completableFuture.join() + "小白开始吃饭了！");
    }

    /**
     * 任务编排
     * 用于两个任务的前后依赖关系，后一个任务依赖前一个任务的结果输出，总的结果由第二个线程汇总输出
     */
    public static void demo2() {
        print("小白进入餐厅！");
        print("小白点了番茄炒蛋和一份米饭~");

        CompletableFuture<String> objectCompletableFuture = CompletableFuture.supplyAsync(() -> {
            print("厨师开始炒菜了~");
            SleepWork(600);
            return "番茄炒蛋准备好了~";
        }).thenComposeAsync(str -> CompletableFuture.supplyAsync(() -> {
            print("服务员开始打饭了~");
            SleepWork(100);
            return str + "米饭也打好了~";
        }));

        print(objectCompletableFuture.join() + "小白开始吃饭了！");
    }

    /**
     * 用CompletableFuture开启一个异步任务
     * 然后在主线程中等待异步任务的结束
     */
    public static void demo1() {
        print("小白进入餐厅！");
        print("小白点了番茄炒蛋和一份米饭~");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                    print("厨师开始准备食材");
                    SleepWork(200);
                    print("厨师开始炒菜了~");
                    SleepWork(600);

                    return "番茄炒蛋准备好了~";
                }

        );
        print(completableFuture.join() + "小白开始吃饭了！");
    }

    public static void SleepWork(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void print(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(Thread.currentThread().getId());
        sb.append("\t");
        sb.append(DateUtil.format(new Date(), NORM_DATETIME_MS_FORMAT));
        sb.append("\t");
        sb.append(msg);
        System.out.println(sb.toString());
    }
}

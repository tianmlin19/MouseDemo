package com.tml.mouseDemo.core.juc;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {

    private int begin;

    private int end;

    public SumTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - begin < 100) {
            long sum = 0;
            for (int i = begin; i <= end; i++) {
                sum += i;
            }
            return sum;

        } else {
            int middle = (begin + end) / 2;
            SumTask sumTask1 = new SumTask(begin, middle);
            SumTask sumTask2 = new SumTask(middle + 1, end);

            sumTask1.fork();
            sumTask2.fork();

            //等待子任务结束
            Long result1 = sumTask1.join();
            Long result2 = sumTask2.join();

            return result1 + result2;

        }
    }
}

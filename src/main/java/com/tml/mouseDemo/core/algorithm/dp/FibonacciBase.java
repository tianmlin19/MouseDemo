package com.tml.mouseDemo.core.algorithm.dp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

@Slf4j
/**
 * 斐波那契数列计算，采用传统的递归方法
 * 递归方法的好处就是代码简单易懂，但弊端也显而易见，这里有大量的重复计算，导致算法的时间复杂度为2^n
 */
public class FibonacciBase {

    public static void main(String[] args) {
        /**
         * 斐波那契数列
         * 0 1 1 2 3 5 8 13
         */
        StopWatch sw = new StopWatch();

        int num = 36;
        sw.start("斐波那契数列计算" + num);
        long fibonacciNum = getFibonacciNum(num);
        log.info("计算斐波那契数列：{}返回结果：{}", num, fibonacciNum);
        sw.stop();


        num = 36;
        sw.start("斐波那契数列计算" + num);
        fibonacciNum = dpfibonacci(num);
        log.info("计算斐波那契数列：{}返回结果：{}", num, fibonacciNum);
        sw.stop();

        System.out.println(sw.prettyPrint());
    }

    /**
     * 普通的递归计算
     *
     * @param num
     * @return
     */
    public static long getFibonacciNum(int num) {
        if (num < 3) {
            return num - 1;
        }
        return getFibonacciNum(num - 1) + getFibonacciNum(num - 2);
    }

    /**
     * 采用自底向上的方式计算
     *
     * @param num 斐波那契数列的第几个数从1开始
     *            0 1 1 2 3 5 8 13
     * @return
     */
    public static long dpfibonacci(int num) {
        long[] dp = new long[num];
        dp[1] = 1;
        if (num < 3) {
            return dp[num - 1];
        }
        for (int i = 2; i < num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[num - 1];
    }
}

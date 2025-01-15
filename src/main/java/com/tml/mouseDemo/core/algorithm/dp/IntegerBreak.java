package com.tml.mouseDemo.core.algorithm.dp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegerBreak {



    public static void main(String[] args) {
        int num = 3;
        int solution = solution(num);

        log.info("num:{}--solution:{}", num, solution);

    }

    /**
     * 整数num拆分成n个正整数的和，求最大的和
     * @param num
     * @return
     */
    public static int solution(int num){
        int[] dp = new int[num + 1];
        dp[2] = 1;
        for (int i = 3; i <= num; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Integer.max(dp[i], Integer.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[num];
    }
}

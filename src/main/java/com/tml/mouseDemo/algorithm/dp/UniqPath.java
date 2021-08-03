package com.tml.mouseDemo.algorithm.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniqPath {

    public static void main(String[] args) {
        System.out.println(solution(2, 3));
    }

    public static int solution(int m,int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m - 1][n - 1];
    }
}

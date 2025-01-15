package com.tml.mouseDemo.core.algorithm.leetcode;

/**
 * 最大子序列
 */
public class MaximumSubarray {


    public static void main(String[] args) {
        int[] ints = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray2(ints);
        System.out.println(i);

    }

    /**
     * 暴力求解
     * 两层循环
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if (tmp > max) {
                max = tmp;
            }
            for (int j = i + 1; j < nums.length; j++) {
                tmp += nums[j];
                if (tmp > max) {
                    max = tmp;
                }
            }
        }

         
        return max;
    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int subArray = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            subArray += num;
            if (subArray < 0) {
                subArray = 0;
            } else {
                if (subArray > max) {
                    max = subArray;
                }
            }

            if (num > max) {
                max = num;
            }


        }


        return max;
    }


    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {

        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + num;
            }

            if (dp[i]>max){
                max = dp[i];
            }

        }

        return max;

    }
}

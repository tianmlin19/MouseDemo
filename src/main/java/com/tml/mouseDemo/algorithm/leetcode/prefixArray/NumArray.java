package com.tml.mouseDemo.algorithm.leetcode.prefixArray;

public class NumArray {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 2, 4, 8, 9});

        int sumRange = numArray.sumRange(2, 4);

        System.out.println(sumRange);

    }

    private int[] prefixArray = null;

    public NumArray(int[] nums) {
        prefixArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixArray[i] = nums[i];
            } else {
                prefixArray[i] = prefixArray[i - 1] + nums[i];
            }

        }
    }

    public int sumRange(int left, int right) {
        if (prefixArray == null) {
            return -1;
        }
        if (right > prefixArray.length) {
            return -1;
        }
        return prefixArray[right] - (left == 0 ? 0 : prefixArray[left - 1]);
    }
}

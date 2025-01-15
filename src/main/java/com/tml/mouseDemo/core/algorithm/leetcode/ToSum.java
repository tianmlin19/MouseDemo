package com.tml.mouseDemo.core.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * <p>
 * 所以返回[0, 1]
 */
public class ToSum {

    public static void main(String[] args) {

        int[] array = new int[]{2, 7, 11, 15};
        int target = 26;

        int[] twoSum = getTwoSumLoop(array, target);

        System.out.println(Arrays.toString(twoSum));


        int[] twoSumMap = getTwoSumMap(array, target);
        System.out.println(Arrays.toString(twoSumMap));

    }


    /**
     * 两层循环 此时的时间复杂度是O（n^2）
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] getTwoSumLoop(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    /**
     * 此时的时间复杂度是O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] getTwoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && (map.get(target - nums[i]) != i)) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }

        return null;
    }
}

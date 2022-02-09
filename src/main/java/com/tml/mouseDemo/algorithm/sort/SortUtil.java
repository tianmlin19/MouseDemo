package com.tml.mouseDemo.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 排序的工具
 */
public class SortUtil {

    /**
     * 随机生成数组
     *
     * @param size
     * @return
     */
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10000);
        }

        return array;
    }


    public static boolean check(int size) {
        int[] arr = generateRandomArray(size);
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        SelectSort.selectionSort(arr2);
        Arrays.sort(arr);

        boolean checkFlag = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]) {
                checkFlag = false;
            }
        }
        return checkFlag;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            boolean check = SortUtil.check(1000);

            System.out.println(check);
        }
    }


}

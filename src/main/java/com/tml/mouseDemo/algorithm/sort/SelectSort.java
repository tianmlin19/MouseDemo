package com.tml.mouseDemo.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度为O（n2）
 */
@Slf4j
public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {5, 7, 1, 8, 3, 9, 0, 4, 2};


        selectionSort(arr);

        System.out.println("____________________________");
        System.out.println("排序之后的结果为：" + Arrays.toString(arr));

    }


    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            //交换i和minpos的位置
            int tmp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = tmp;
            //System.out.println("第" + i + "次排序结果：" + Arrays.toString(arr));
        }
    }

}

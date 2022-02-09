package com.tml.mouseDemo.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


/**
 * 冒泡排序时间复杂度最坏O（n2），最好O（n），
 */
@Slf4j
public class Maopao {

    public static void main(String[] args) {
        int[] arrsy = new int[]{3,20,5,74,8,9};

        log.info("排序前：{}", Arrays.toString(arrsy));
        sort1(arrsy);

        log.info("排序后：{}", Arrays.toString(arrsy));
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

    }

    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int flag = 1;

            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;

                    flag = 0;
                }
            }

            if (flag == 1) {
                //此时说明数组已经是有序的
                return;
            }
        }

    }


    public static void sort2(int[] array) {



        int len = array.length - 1;
        int lastChangePos = 0;


        for (int i = 0; i < array.length - 1; i++) {

            int flag = 1;
            for (int j = 0; j < len; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;

                    flag = 0;
                    //记录最后一个交换位置的下标
                    lastChangePos = j;
                }
            }

            len = lastChangePos;
            if (flag == 1) {
                //此时说明数组已经是有序的
                return;
            }
        }

    }
}

package com.tml.mouseDemo.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Maopao {

    public static void main(String[] args) {
        int[] arrsy = new int[]{10, 3, 5, 23, 9};

        log.info("排序前：{}", Arrays.toString(arrsy));
        sort(arrsy);

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
}

package com.tml.mouseDemo.core.algorithm.dp.pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pack01 {

    /**
     * 背包问题  暴力破解
     * 一个可以承载4kg的背包
     * A物品3000  4
     * B物品2000  3
     * C物品1500  1
     *
     * @param args
     */
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(4, 3000);
        map.put(3, 2000);
        map.put(1, 1500);
    }


    public static void pack(Map<Integer, Integer> map, int totalSize) {
        List<Integer> list = new ArrayList<>(map.keySet());
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; i < list.size(); j++) {
                System.out.println(j);
            }
        }
    }
}

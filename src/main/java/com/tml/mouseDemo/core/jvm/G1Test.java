package com.tml.mouseDemo.core.jvm;


import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx60M -Xms60M  -XX:+UseG1GC -XX:+PrintGCDetails
 * 设置垃圾回收器为G1
 */
public class G1Test {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            byte[] arr = new byte[1024 * 100];

            list.add(arr);
        }
    }
}

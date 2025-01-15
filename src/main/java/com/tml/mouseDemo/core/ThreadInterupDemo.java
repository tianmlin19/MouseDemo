package com.tml.mouseDemo.core;


import cn.hutool.core.io.IoUtil;

import java.io.FileInputStream;

/**
 * 在Thread类中有interrupt()，interrupted()和isInterrupted()方法与线程的中断有关
 */
public class ThreadInterupDemo {

    public static void main(String[] args) {


        Thread thread = new Thread(() -> {
            try {
                String regex = "^(a+)+$";
                String filePath = "C:\\Users\\Dell\\Desktop\\阿里P9纯手打亿级高并发系统设计手册.pdf";
                String read1 = IoUtil.read(new FileInputStream(filePath), "UTF-8");
                System.out.println(read1);

                /*for (int i = 0; i < 400; i++) {
                    String targetStr = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaX";
                    Pattern compile = Pattern.compile(regex);
                    boolean matches = compile.matcher(targetStr).matches();
                    System.out.println("current times:" + i + "matches flag:" + matches);
                }*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("hello");

        });

        thread.start();
        thread.interrupt();
    }
}

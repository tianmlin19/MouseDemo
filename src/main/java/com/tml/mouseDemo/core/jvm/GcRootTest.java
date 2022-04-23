package com.tml.mouseDemo.core.jvm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GcRootTest {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Date date = new Date();

        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        System.out.println("数据添加完毕！");

        new Scanner(System.in).next();
        list = null;
        date = null;

        System.out.println("数据已经置空");
        new Scanner(System.in).next();

        System.out.println("结束");

    }
}

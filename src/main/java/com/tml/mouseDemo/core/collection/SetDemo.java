package com.tml.mouseDemo.core.collection;

import org.apache.dubbo.common.utils.ConcurrentHashSet;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetDemo {

    public static void main(String[] args) {
        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet();

        set.add(5);
        set.add(2);
        set.add(9);
        set.add(1);

        for (Integer integer:set){
            System.out.println(integer);
        }
    }

    public static void  testLinkedHashSet(){
        Set<String> set = new LinkedHashSet<>();
        set.add("吕布");
        set.add("关羽");
        set.add("张飞");
        set.add("刘备");
        for (String str:set){
            System.out.println(str);

        }
    }

    public static void testTreeSet(){
        TreeSet<Integer> set1 = new TreeSet();
        set1.add(8);
        set1.add(5);
        set1.add(10);
        set1.add(2);
        set1.add(28);
        for (Integer res : set1) {
            System.out.println(res);
        }
    }
}

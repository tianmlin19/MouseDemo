package com.tml.mouseDemo.core.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

public class MapDemo {

    public static void main(String[] args) throws InterruptedException {

    }

    public static void testWeakHashMap() throws InterruptedException {
        WeakHashMap<M, V> map = new WeakHashMap<>();
        map.put(new M(), new V());


        //触发gc
        System.gc();

        Thread.sleep(3000);

        map.put(new M(), new V());

        Thread.sleep(1000000);
    }


    /**
     * LinkedHashMap实现了LRU算法
     */
    public static void testLinkedHashMap(){

        LinkedHashMap<String, String> mp = new LinkedHashMap(16,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if (this.size() > 3) {
                    return true;
                }else {
                    return false;
                }
            }
        };

        mp.put("tml", "hhh");
        mp.put("qaz", "sdfsdf");
        mp.put("www", "dfsgfdg");


        Set<Map.Entry<String, String>> entries = mp.entrySet();
        for (Map.Entry<String, String> res : entries) {
            System.out.println(res.getKey());
        }

        mp.get("tml");

        System.out.println("\n");

        entries = mp.entrySet();
        for (Map.Entry<String, String> res : entries) {
            System.out.println(res.getKey());
        }

        System.out.println("\n");
        mp.put("7777", "jjj");

        entries = mp.entrySet();
        for (Map.Entry<String, String> res : entries) {
            System.out.println(res.getKey());
        }
    }

    public static void testTreeMap() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(18, "sdfsdf");
        map.put(1, "ddd");
        map.put(10, "kjj");

        Map.Entry<Integer, String> integerStringEntry =
                map.firstEntry();
        System.out.println(integerStringEntry.getKey());
    }
}

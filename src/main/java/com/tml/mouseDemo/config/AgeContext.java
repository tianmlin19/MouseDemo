package com.tml.mouseDemo.config;

import com.alibaba.ttl.TransmittableThreadLocal;

public class AgeContext {
 
    private static final ThreadLocal<String> AGE = new TransmittableThreadLocal<>();
 
    public static String get() {
        return AGE.get();
    }
 
    public static void set(String age) {
        AGE.set(age);
    }
 
    public static void clean() {
        if (AGE.get() != null) {
            AGE.remove();
        }
    }
 
}
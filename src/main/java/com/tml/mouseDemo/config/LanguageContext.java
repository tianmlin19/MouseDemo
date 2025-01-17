package com.tml.mouseDemo.config;

import com.alibaba.ttl.TransmittableThreadLocal;

public class LanguageContext {
 
    private static final ThreadLocal<String> LANGUAGE = new TransmittableThreadLocal<>();
 
    public static String get() {
        return LANGUAGE.get();
    }
 
    public static void set(String age) {
        LANGUAGE.set(age);
    }
 
    public static void clean() {
        if (LANGUAGE.get() != null) {
            LANGUAGE.remove();
        }
    }
 
}
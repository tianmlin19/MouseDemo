package com.tml.mouseDemo.config;

import com.alibaba.ttl.TransmittableThreadLocal;

public class TraceContext {

    private static final ThreadLocal<String> TRACE_CONTEXT = new TransmittableThreadLocal<>();

    public static String get() {
        return TRACE_CONTEXT.get();
    }

    public static void set(String age) {
        TRACE_CONTEXT.set(age);
    }

    public static void clean() {
        if (TRACE_CONTEXT.get() != null) {
            TRACE_CONTEXT.remove();
        }
    }
}

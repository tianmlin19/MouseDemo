package com.tml.mouseDemo.core.collection;

public class V {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("V is clear!");
    }
}

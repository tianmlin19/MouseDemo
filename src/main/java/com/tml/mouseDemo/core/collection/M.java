package com.tml.mouseDemo.core.collection;

public class M {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("M clear-------------");

    }
}

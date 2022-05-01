package com.tml.mouseDemo.core.spi;

public class TwoSomeService implements JdkSpiService{
    @Override
    public void doSomeService() {
        System.out.println("TwoSomeService doSomeService！");
    }
}

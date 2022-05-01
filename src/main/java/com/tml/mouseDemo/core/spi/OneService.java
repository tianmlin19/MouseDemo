package com.tml.mouseDemo.core.spi;

public class OneService implements JdkSpiService {
    @Override
    public void doSomeService() {
        System.out.println("OneService doSomeService!");
    }
}

package com.tml.mouseDemo.core.spi.jdk;

public class OneService implements JdkSpiService {
    @Override
    public void doSomeService() {
        System.out.println("OneService doSomeService!");
    }
}

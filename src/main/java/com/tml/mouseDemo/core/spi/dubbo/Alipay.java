package com.tml.mouseDemo.core.spi.dubbo;

public class Alipay implements Pay{
    @Override
    public void getPayType() {
        System.out.println("this is alipay!");
    }
}

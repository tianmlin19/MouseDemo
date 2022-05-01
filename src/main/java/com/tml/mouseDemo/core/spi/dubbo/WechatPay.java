package com.tml.mouseDemo.core.spi.dubbo;

public class WechatPay implements Pay {
    @Override
    public void getPayType() {
        System.out.println("this is wechatPay!");
    }
}

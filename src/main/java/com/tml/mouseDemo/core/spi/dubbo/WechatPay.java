package com.tml.mouseDemo.core.spi.dubbo;

import org.apache.dubbo.common.URL;

public class WechatPay implements Pay {
    @Override
    public void getPayType() {
        System.out.println("this is wechatPay!");
    }

    @Override
    public void dowork(URL url) {
        System.out.println("url " + url);
        System.out.println("this is 微信！");
    }
}

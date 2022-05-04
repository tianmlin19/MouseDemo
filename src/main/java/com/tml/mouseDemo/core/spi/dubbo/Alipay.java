package com.tml.mouseDemo.core.spi.dubbo;

import org.apache.dubbo.common.URL;

public class Alipay implements Pay{
    @Override
    public void getPayType() {
        System.out.println("this is alipay!");
    }


    @Override
    public void dowork(URL url) {
        System.out.println("url--" + url);
        System.out.println("this is 支付宝！" );
    }
}

package com.tml.mouseDemo.core.spi.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class DubboSpiMain {

    public static void main(String[] args) {
        ExtensionLoader<Pay> extensionLoader = ExtensionLoader.getExtensionLoader(Pay.class);

        //获取指定名称的扩展类
        Pay alipay = extensionLoader.getExtension("alipay");

        Pay wechatpay = extensionLoader.getExtension("wechatpay");

        alipay.getPayType();
        wechatpay.getPayType();


        System.out.println("自适应adaptive类");
        Pay adaptiveExtension = extensionLoader.getAdaptiveExtension();

        ((AdaptivePay) adaptiveExtension).setPayName("wechatpay");

        adaptiveExtension.getPayType();


        System.out.println("自适应adaptive方法");


        Pay tmp = extensionLoader.getAdaptiveExtension();
        URL url = URL.valueOf("xxx://localhost/kkkk");
        tmp.dowork(url);


        URL url1 = URL.valueOf("xxx://localhost/kkkk?pay=wechatpay");
        tmp.dowork(url1);

    }
}

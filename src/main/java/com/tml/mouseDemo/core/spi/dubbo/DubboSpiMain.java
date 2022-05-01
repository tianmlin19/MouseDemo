package com.tml.mouseDemo.core.spi.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class DubboSpiMain {

    public static void main(String[] args) {
        ExtensionLoader<Pay> extensionLoader = ExtensionLoader.getExtensionLoader(Pay.class);

        //获取指定名称的扩展类
        Pay alipay = extensionLoader.getExtension("alipay");

        Pay wechatpay = extensionLoader.getExtension("wechatpay");

        alipay.getPayType();
        wechatpay.getPayType();

    }
}

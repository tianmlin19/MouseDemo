package com.tml.mouseDemo.core.spi.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.springframework.util.StringUtils;

@Adaptive
public class AdaptivePay implements Pay {

    private String payName;

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    @Override
    public void getPayType() {
        ExtensionLoader<Pay> extensionLoader = ExtensionLoader.getExtensionLoader(Pay.class);
        Pay pay = null;
        if (StringUtils.hasText(payName)) {
            pay = extensionLoader.getExtension(payName);
        } else {
            pay = extensionLoader.getDefaultExtension();
        }

        pay.getPayType();
    }

    @Override
    public void dowork(URL url) {
        System.out.println("this is AdaptivePay");
    }
}

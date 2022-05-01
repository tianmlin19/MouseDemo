package com.tml.mouseDemo.core.spi.dubbo;

import org.apache.dubbo.common.extension.SPI;

@SPI(value = "alipay")
public interface Pay {

    void getPayType();
}

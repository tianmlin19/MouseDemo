package com.tml.mouseDemo.core.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * JDK的SPI机制
 *
 * 会加载META-INF/services目录下的接口文件
 *
 *
 */
public class JdkSpiMain {

    public static void main(String[] args) {
        ServiceLoader<JdkSpiService> loader = ServiceLoader.load(JdkSpiService.class);
        Iterator<JdkSpiService> iterator = loader.iterator();

        while (iterator.hasNext()){
            JdkSpiService next = iterator.next();
            next.doSomeService();

        }
    }
}

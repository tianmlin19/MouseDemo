package com.tml.mouseDemo.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class CommonConfig {

    @Bean
    /**
     * 线程池配置
     */
    public ThreadPoolExecutor threadPoolExecutor() {
        int processors = Runtime.getRuntime().availableProcessors();
        log.info("processors:{}", processors);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(processors, processors, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        return executor;
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping().create();
    }
}

package com.tml.mouseDemo.config;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Slf4j
@Configuration
public class CommonConfig {

    Thread.UncaughtExceptionHandler exceptionHandler = (Thread t, Throwable e) -> {
        log.info("current thread occurs error！", e);
    };

    @Bean
    public ThreadPoolExecutor executor() {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().
                setUncaughtExceptionHandler(exceptionHandler).
                setNameFormat("mouse-worker-%d").build();
        int processors = Runtime.getRuntime().availableProcessors();
        log.info("processors:{}", processors);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
                processors * 2,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1000),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }


    /**
     * 使用阿里的 TransmittableThreadLocal 装饰线程池
     * @return
     */
    @Bean
    public Executor ttlExecutor() {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().
                setUncaughtExceptionHandler(exceptionHandler).
                setNameFormat("mouse-worker-ttl-%d").build();
        int processors = Runtime.getRuntime().availableProcessors();
        log.info("processors:{}", processors);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
                processors * 2,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1000),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        Executor ttlExecutor = TtlExecutors.getTtlExecutor(executor);
        return ttlExecutor;
    }


    @Bean
    public ThreadPoolExecutor uncaughtExceptionExecutor() {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().
                setNameFormat("uncaughtException-worker-%d").build();
        int processors = Runtime.getRuntime().availableProcessors();
        log.info("processors:{}", processors);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(processors,
                processors * 2,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1000),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }






    @Bean
    public CustomThreadPoolExecutor customExecutor() {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().
                setNameFormat("custom-worker-%d").build();
        int processors = Runtime.getRuntime().availableProcessors();
        log.info("processors:{}", processors);
        CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(processors,
                processors * 2,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1000),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping().create();
    }
}

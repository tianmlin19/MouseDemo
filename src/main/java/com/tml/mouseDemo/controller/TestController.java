package com.tml.mouseDemo.controller;

import cn.hutool.core.util.StrUtil;
import com.tml.mouseDemo.config.LanguageContext;
import com.tml.mouseDemo.constants.CommonResponse;
import com.tml.mouseDemo.constants.I18nKey;
import com.tml.mouseDemo.core.i18n.I18nUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private ThreadPoolExecutor executor;

    @Autowired
    private Executor ttlExecutor;

    @GetMapping("/common")
    public CommonResponse<String> commonHandler() {
        return CommonResponse.success("common handler");
    }


    @PostMapping("/i18n")
    public CommonResponse<String> i18nHandler(String pwd) {
        log.info("i18nHandler pwd:{}",pwd);
        if (StrUtil.isBlank(pwd)||pwd.length()<6) {
            return CommonResponse.failWithI18n(I18nKey.INVALID_PWD);
        }
        return CommonResponse.success("common handler");
    }

    @PostMapping("/i18nHandlerWithThread")
    public CommonResponse<String> i18nHandlerWithThread(String pwd) {
        log.info("i18nHandler pwd:{}",pwd);

        if (StrUtil.isBlank(pwd)||pwd.length()<6) {
            return CommonResponse.failWithI18n(I18nKey.INVALID_PWD);
        }
        //模拟异步发短信
        new Thread(()->{
            try {
                Thread.sleep(2000);
                String sendMsg = I18nUtil.getI18nMessage(I18nKey.SAY_HELLO);
                log.info("i18nHandler sendMsg:{}",sendMsg);

            }catch (Exception e) {
                log.error("i18nHandlerWithThread occur error", e);
            }

        },"i18n--001").start();

        return CommonResponse.success("common handler");
    }

    @PostMapping("/i18nHandlerWithThreadPool")
    public CommonResponse<String> i18nHandlerWithThreadPool(String pwd) {
        log.info("i18nHandler pwd:{}",pwd);

        if (StrUtil.isBlank(pwd)||pwd.length()<6) {
            return CommonResponse.failWithI18n(I18nKey.INVALID_PWD);
        }
        //模拟异步发短信
        executor.execute(()->{
            try {
                Thread.sleep(2000);
                String sendMsg = I18nUtil.getI18nMessage(I18nKey.SAY_HELLO);
                log.info("i18nHandler sendMsg:{}",sendMsg);

            }catch (Exception e) {
                log.error("i18nHandlerWithThread occur error", e);
            }
        });

        //模拟异步发短信
        ttlExecutor.execute(()->{
            try {
                Thread.sleep(2000);
                String sendMsg = I18nUtil.getI18nMessage(I18nKey.SAY_HELLO);
                log.info("i18nHandler sendMsg:{}",sendMsg);

            }catch (Exception e) {
                log.error("i18nHandlerWithThread occur error", e);
            }
        });



        return CommonResponse.success("common handler");
    }

}

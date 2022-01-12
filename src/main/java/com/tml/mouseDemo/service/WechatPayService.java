package com.tml.mouseDemo.service;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "wechatPay")
@Slf4j
public class WechatPayService extends AbstractPayService {

    @Autowired
    private Gson gson;

    @Override
    public String pay() {
        super.pay();

        log.info("WechatPayService ");

        return "WechatPayService";

    }
}

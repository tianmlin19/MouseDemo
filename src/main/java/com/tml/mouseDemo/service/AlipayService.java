package com.tml.mouseDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service(value = "alipay")
@Slf4j
public class AlipayService extends AbstractPayService{

    @Override
    public String pay() {
        super.pay();

        log.info("AlipayService ");

        return "AlipayService";
    }

}

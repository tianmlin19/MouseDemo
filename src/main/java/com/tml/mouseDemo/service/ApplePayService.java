package com.tml.mouseDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service(value = "applePay")
public class ApplePayService extends AbstractPayService {

    @Override
    public String pay() {
        super.pay();

        log.info("ApplePayService");

        return "ApplePayService";
    }
}

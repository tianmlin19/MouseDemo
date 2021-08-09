package com.tml.mouseDemo.service.impl;

import com.tml.mouseDemo.core.annotation.SystemLog;
import com.tml.mouseDemo.service.InvestDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InvestDetailServiceImpl implements InvestDetailService {

    @Override
    @SystemLog(type = "方天画戟")
    public double caculateInvest(long num, double price) {
        log.info("InvestDetailService caculateInvest");

        return num * price * 100;
    }
}

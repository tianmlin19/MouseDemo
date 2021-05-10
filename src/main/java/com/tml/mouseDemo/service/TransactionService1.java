package com.tml.mouseDemo.service;

import com.google.gson.Gson;
import com.tml.mouseDemo.data.data1.mapper.InvestDetailMapper;
import com.tml.mouseDemo.data.data2.mapper.UserMapper;
import com.tml.mouseDemo.model.InvestDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TransactionService1 {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InvestDetailMapper investDetailMapper;

    @Autowired
    private Gson gson;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void distributeTransaction() {
        InvestDetail oneRecord = investDetailMapper.getOneRecord(2l);
        log.info("oneRecord:{}", oneRecord);
        investDetailMapper.updateTax(oneRecord.getTax() + 1, 2L);
        throw new RuntimeException("");
    }
}

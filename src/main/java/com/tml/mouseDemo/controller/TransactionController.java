package com.tml.mouseDemo.controller;


import com.google.gson.Gson;
import com.tml.mouseDemo.constants.CommonResponse;
import com.tml.mouseDemo.data.data1.mapper.InvestDetailMapper;
import com.tml.mouseDemo.model.InvestDetail;
import com.tml.mouseDemo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private InvestDetailMapper investDetailMapper;

    @Autowired
    private Gson gson;

    @GetMapping("demo1")
    public String transaction() {
        InvestDetail investBefore = investDetailMapper.getOneRecord(1L);
        //transactionService.testCallMyself(investBefore);
        return gson.toJson(CommonResponse.success("success"));
    }

}

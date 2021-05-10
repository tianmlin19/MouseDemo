package com.tml.mouseDemo.controller;


import com.google.gson.Gson;
import com.tml.mouseDemo.constants.CommonResponse;
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
    private Gson gson;

    @GetMapping("demo1")
    public String transaction() {
        //transactionService.distributeTransaction();
        return gson.toJson(CommonResponse.success("success"));
    }

}

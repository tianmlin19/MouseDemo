package com.tml.mouseDemo.controller;


import com.tml.mouseDemo.constants.CommonResponse;
import com.tml.mouseDemo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("demo1")
    public CommonResponse transaction() {
        return CommonResponse.success("success");

    }
}

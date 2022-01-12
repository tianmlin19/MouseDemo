package com.tml.mouseDemo.service;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public abstract class AbstractPayService implements BaseService {

    @Autowired
    private UserService userService;

    @Autowired
    private Gson gson;

    @Override
    public String pay() {
        String printUser = userService.printUser(this.getClass().getName(), "hello world!");
        log.info("printUser:{}", printUser);
        return null;
    }
}

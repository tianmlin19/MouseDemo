package com.tml.mouseDemo.service.impl;

import com.tml.mouseDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public String printUser(String userName,String value) {
        log.info("UserService printUser！");

        return userName + value;
    }
}

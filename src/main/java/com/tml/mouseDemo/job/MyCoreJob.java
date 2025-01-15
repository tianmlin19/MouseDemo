package com.tml.mouseDemo.job;

import com.tml.mouseDemo.mapper.UserMapper;
import com.tml.mouseDemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MyCoreJob {

    @Autowired
    private UserMapper userMapper;

    @Scheduled(cron = "0 */1 * * * ?")
    public void testOk(){
        log.info("testOk");
        List<User> list = userMapper.listByName("tml");
        log.info("oneUser:{}", list.size());

    }
}

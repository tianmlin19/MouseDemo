package com.tml.mouseDemo;

import com.tml.mouseDemo.data.data1.mapper.InvestDetailMapper;
import com.tml.mouseDemo.data.data2.mapper.UserMapper;
import com.tml.mouseDemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class MouseDemoApplicationTests {

    @Autowired
    private InvestDetailMapper investDetailMapper;

    @Autowired
    private UserMapper userMapper;


    @Test
    void contextLoads() throws Exception {
        List<User> tml = userMapper.listByName("tml");

        log.info("tml:{}", tml);

    }

}

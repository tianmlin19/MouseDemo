package com.tml.mouseDemo;

import com.tml.mouseDemo.service.InvestDetailService;
import com.tml.mouseDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AopTest {

    @Autowired
    private UserService userService;

    @Autowired
    private InvestDetailService investDetailService;

    @Test
    public void testBeforeAdvice() {
        String tml = userService.printUser("tml", "10086");
        log.info("tml:{}", tml);
    }

    @Test
    public void testAfterAdvice(){
        double caculateInvest = investDetailService.caculateInvest(700, 143.22);
        log.info("caculateInvest:{}", caculateInvest);
    }
}

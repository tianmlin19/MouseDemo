package com.tml.mouseDemo;

import com.tml.mouseDemo.service.BaseService;
import com.tml.mouseDemo.service.InvestDetailService;
import com.tml.mouseDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AopTest {

    @Autowired
    private UserService userService;

    @Autowired
    private InvestDetailService investDetailService;

    @Autowired
    private Map<String, BaseService> payMap;


    @Test
    public void testCustomExecutor() throws Exception {


        userService.customExecutor();
    }

    @Test
    public void testExecutorExecute() throws Exception {
        userService.executorLogTest();
    }

    @Test
    public void testExecutorSubmit() throws ExecutionException, InterruptedException {
        userService.executorSubmitTest();

    }

    @Test
    public void testAfterAdvice() {
        double caculateInvest = investDetailService.caculateInvest(700, 143.22);
        log.info("caculateInvest:{}", caculateInvest);
    }

    @Test
    public void testBinary() {
        for (int i = 1; i < 101; i++) {
            String result = Integer.toBinaryString(i);
            String substring = result.substring(0, result.length() - 1);
            if (substring.endsWith("1")) {
                System.out.println(i);

            }

        }

    }

}

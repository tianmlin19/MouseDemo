package com.tml.mouseDemo;

import com.tml.mouseDemo.data.data1.mapper.InvestDetailMapper;
import com.tml.mouseDemo.model.InvestDetail;
import com.tml.mouseDemo.service.BaseService;
import com.tml.mouseDemo.service.InvestDetailService;
import com.tml.mouseDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
@Slf4j
public class AopTest {

    @Autowired
    private UserService userService;

    @Autowired
    private InvestDetailService investDetailService;

    @Autowired
    private InvestDetailMapper investDetailMapper;

    @Autowired
    private Map<String, BaseService> payMap;

    @Test
    public void testBeforeAdvice() {

        List<InvestDetail> investDetails = investDetailMapper.listInvestByStockName("招商银行");
        log.info("investDetails:{}", investDetails);

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

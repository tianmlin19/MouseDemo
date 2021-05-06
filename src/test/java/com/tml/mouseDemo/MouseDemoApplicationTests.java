package com.tml.mouseDemo;

import com.tml.mouseDemo.data.data1.mapper.InvestDetailMapper;
import com.tml.mouseDemo.model.InvestDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class MouseDemoApplicationTests {

    @Autowired
    public InvestDetailMapper investDetailMapper;


    @Test
    void contextLoads() throws Exception {
        List<InvestDetail> details = investDetailMapper.listInvestByStockName("TCL科技");
        log.info("details:{}", details);

    }

}

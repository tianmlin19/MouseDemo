package com.tml.mouseDemo.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyCoreJob {
    @Scheduled(cron = "0 */10 * * * ?")
    public void testOk(){
        log.info("testOk");
    }
}

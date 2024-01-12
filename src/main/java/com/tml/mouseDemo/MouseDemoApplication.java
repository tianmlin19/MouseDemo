package com.tml.mouseDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.tml.mouseDemo.mapper")
public class MouseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MouseDemoApplication.class, args);
    }

}

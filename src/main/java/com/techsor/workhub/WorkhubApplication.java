package com.techsor.workhub;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.techsor.workhub.mapper")
public class WorkhubApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkhubApplication.class, args);
    }

}

package com.ricemarch.cms.pms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ricemarch.cms.pms.mapper")
public class RicemarchDfmcCmsPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RicemarchDfmcCmsPmsApplication.class, args);
    }

}

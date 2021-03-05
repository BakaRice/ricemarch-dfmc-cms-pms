package com.ricemarch.cms.pms.service;

import com.ricemarch.cms.pms.entity.SysReqLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author RiceMarch
 * @date 2021/3/5 20:39
 */
@SpringBootTest
class SysReqLogServiceTest {

    @Autowired
    SysReqLogService sysReqLogService;

    @Test
    public void insert() {
        Random random = new Random();

        SysReqLog sysReqLog = new SysReqLog();
        sysReqLog.setStoreId(random.nextLong());
        sysReqLog.setToken(UUID.randomUUID().toString().replace("-", ""));
        sysReqLog.setRequri("reqUri-" + random.nextInt());
        sysReqLog.setRequestid(random.ints().toString());

        sysReqLog.setCreatetime(LocalDateTime.now());

        sysReqLogService.save(sysReqLog);
    }
}
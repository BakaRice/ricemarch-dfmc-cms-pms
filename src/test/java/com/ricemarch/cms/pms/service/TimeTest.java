package com.ricemarch.cms.pms.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author RiceMarch
 * @date 2021/3/5 21:50
 */
public class TimeTest {
    @Test
    public void time() {
        System.out.println(LocalDateTime.now(ZoneId.of("+08:00")));
    }
}

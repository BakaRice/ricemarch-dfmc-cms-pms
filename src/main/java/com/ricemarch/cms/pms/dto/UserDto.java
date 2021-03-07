package com.ricemarch.cms.pms.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户 数据传输对象
 *
 * @author RiceMarch
 * @date 2021/3/7 15:44
 */
@Data
@Slf4j
public class UserDto {

    private int id;
    private String name;
    private int state;
    private double salary;
}

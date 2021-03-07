package com.ricemarch.cms.pms.bo.request;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于登录的request 对象
 *
 * @author RiceMarch
 * @date 2021/3/7 18:51
 */
@Data
@Slf4j
public class LoginReq extends BaseRequest {

    private String phone;

    private String password;

}

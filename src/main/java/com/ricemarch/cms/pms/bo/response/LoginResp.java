package com.ricemarch.cms.pms.bo.response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 登录后的反馈
 *
 * @author RiceMarch
 * @date 2021/3/7 18:49
 */
@Data
@Slf4j
public class LoginResp extends BaseResp {

    private String role;

}

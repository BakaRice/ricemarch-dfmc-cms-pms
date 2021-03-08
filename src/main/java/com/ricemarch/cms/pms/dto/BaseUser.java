package com.ricemarch.cms.pms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 用户 数据传输对象
 *
 * @author RiceMarch
 * @date 2021/3/7 15:44
 */
@Data
@Slf4j
public class BaseUser {

    private Long accountId;
    private String password;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("登录账号")
    private String account;

    @ApiModelProperty("组织id")
    private Long orgId;

    @ApiModelProperty("组织名称")
    private String orgName;

    @ApiModelProperty("企业id")
    private Long tenantId;

    @ApiModelProperty("企业名称")
    private String tenantName;

//    @ApiModelProperty("角色列表")
//    private List<CurrentAccountRoleResp> userRoleList;

    @ApiModelProperty("用户名称")
    private String username;

    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
}

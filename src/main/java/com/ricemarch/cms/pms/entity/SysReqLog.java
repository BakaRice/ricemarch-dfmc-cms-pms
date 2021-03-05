package com.ricemarch.cms.pms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

import lombok.*;

/**
 * <p>
 *
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-05
 */
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SysReqLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 请求来源 order
     */
    private String source;

    /**
     * companyId
     */
    private Long companyId;

    /**
     * tenant_id
     */
    private Long tenantId;

    /**
     * storeId
     */
    private Long storeId;

    /**
     * org_id
     */
    private Long orgId;

    /**
     * account
     */
    private String account;

    /**
     * openId
     */
    private String openId;

    /**
     * 门店用户ID
     */
    private String storeUserId;

    /**
     * user_id
     */
    private Long userId;

    /**
     * 门店对应的用户名称
     */
    private String nickName;

    /**
     * username
     */
    private String username;

    /**
     * 用户token
     */
    private String token;

    /**
     * 请求url
     */
    @TableField("reqUrl")
    private String requrl;

    /**
     * 请求uri
     */
    @TableField("reqUri")
    private String requri;

    /**
     * 接口耗时ms
     */
    private String time;

    /**
     * 请求方式post get
     */
    private String method;

    /**
     * 请求参数
     */
    @TableField("reqParams")
    private String reqparams;

    /**
     * 返回参数
     */
    @TableField("resParams")
    private String resparams;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createtime;

    /**
     * requestId
     */
    @TableField("requestId")
    private String requestid;

}

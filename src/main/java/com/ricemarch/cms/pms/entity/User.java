package com.ricemarch.cms.pms.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 微信小程序openId
     */
    private String openId;

    /**
     * 微信unionId
     */
    private String unionId;

    /**
     * 名称
     */
    private String username;

    /**
     * 头像链接
     */
    private String headImage;

    /**
     * 密码
     */
    private String password;

    /**
     * 人事状态 on 在职，off 离职
     */
    private String state;

    /**
     * 账号状态 默认未启用
     */
    private Boolean accountState;

    /**
     * 薪水
     */
    private Double salary;

    private String gender;

    private Boolean active;

    /**
     * 年纪
     */
    private Integer age;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 身份证号码
     */
    private String idcardNumber;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 入职时间
     */
    private LocalDate entryDay;

    /**
     * 地址信息
     */
    private String address;

    /**
     * store 门店用户 company 公司用户 tenant 租户用户
     */
    private String userType;

    private Long storeId;

    private Long companyId;

    private Long tenantId;

    /**
     * 组织机构账号ID
     */
    private Long sysUserId;

    /**
     * 密码是否手动设置
     */
    private Boolean resetFlag;

    /**
     * 备注
     */
    private String mark;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    /**
     * 存id
     */
    private String updateUser;

    /**
     * 存id
     */
    private String createUser;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 店员编码
     */
    private String userNo;

    /**
     * 岗位code
     */
    private String positionCode;

    /**
     * 工种code
     */
    private String professionCode;


}

package com.ricemarch.cms.pms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 公司
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司描述
     */
    private String description;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人手机
     */
    private String contactMobilePhone;

    /**
     * 公司电话
     */
    private String telephone;

    /**
     * 公司通讯地址
     */
    private String address;

    /**
     * 营业执照照片
     */
    private String imageUrl;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态 0 正常
     */
    private Integer statusType;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 更新用户
     */
    private String updateUser;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}

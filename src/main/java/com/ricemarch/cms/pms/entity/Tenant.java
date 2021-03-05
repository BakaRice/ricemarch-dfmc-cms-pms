package com.ricemarch.cms.pms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 租户，谁租用了这个系统
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Tenant implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户名称
     */
    private String tenantName;

    /**
     * 签约人姓名
     */
    private String principalName;

    /**
     * 签约人移动电话
     */
    private String principalMobilePhone;

    /**
     * 身份证
     */
    private String principalIdentityCard;

    /**
     * 租户电话
     */
    private String telephone;

    /**
     * 资质照片
     */
    private String imageUrl;

    /**
     * 租户通讯地址
     */
    private String address;

    /**
     * 租户描述
     */
    private String description;

    /**
     * 状态 0 正常
     */
    private Integer statusType;

    /**
     * 开始时间
     */
    private LocalDate beginDate;

    /**
     * 结束时间
     */
    private LocalDate endDate;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}

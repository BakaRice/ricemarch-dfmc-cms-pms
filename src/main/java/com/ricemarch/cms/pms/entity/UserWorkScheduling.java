package com.ricemarch.cms.pms.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 排班记录表
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserWorkScheduling implements Serializable {

    private static final long serialVersionUID = 1L;

      private String id;

    /**
     * 排版开始时间
     */
    private LocalDateTime startTime;

    /**
     * 排班结束时间
     */
    private LocalDateTime endTime;

    /**
     * 工作类型（白班，夜班，出差等）
     */
    private Integer workType;


}

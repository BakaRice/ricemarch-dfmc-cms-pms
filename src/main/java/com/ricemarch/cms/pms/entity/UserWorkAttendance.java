package com.ricemarch.cms.pms.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户工作考勤表
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserWorkAttendance implements Serializable {

    private static final long serialVersionUID = 1L;

      private String id;

    /**
     * 用户id

     */
    private String userId;

    /**
     * 上班时间
     */
    private LocalDateTime startTime;

    /**
     * 下班时间
     */
    private LocalDateTime endTime;

    /**
     * 考勤方式
     */
    private Integer attendanceType;


}

package com.ricemarch.cms.pms.service;

import com.ricemarch.cms.pms.entity.UserWorkAttendance;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户工作考勤表 服务类
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-16
 */
public interface UserWorkAttendanceService extends IService<UserWorkAttendance> {

    void addWorkLog(String userId, int type);
}

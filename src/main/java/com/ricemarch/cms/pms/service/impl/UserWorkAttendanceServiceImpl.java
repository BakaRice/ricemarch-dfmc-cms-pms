package com.ricemarch.cms.pms.service.impl;

import com.ricemarch.cms.pms.entity.UserWorkAttendance;
import com.ricemarch.cms.pms.mapper.UserWorkAttendanceMapper;
import com.ricemarch.cms.pms.service.UserWorkAttendanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户工作考勤表 服务实现类
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-16
 */
@Service
public class UserWorkAttendanceServiceImpl extends ServiceImpl<UserWorkAttendanceMapper, UserWorkAttendance> implements UserWorkAttendanceService {

    @Override
    public void addWorkLog(String userId, int type) {

    }
}

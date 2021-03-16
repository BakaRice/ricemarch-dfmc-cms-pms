package com.ricemarch.cms.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ricemarch.cms.pms.entity.UserWorkScheduling;
import com.ricemarch.cms.pms.mapper.UserWorkSchedulingMapper;
import com.ricemarch.cms.pms.service.UserWorkSchedulingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 排班记录表 服务实现类
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-16
 */
@Service
public class UserWorkSchedulingServiceImpl extends ServiceImpl<UserWorkSchedulingMapper, UserWorkScheduling> implements UserWorkSchedulingService {

    @Resource
    UserWorkSchedulingMapper schedulingMapper;

    @Override
    public int getUserWorkType(String userId) {
        QueryWrapper<UserWorkScheduling> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("")
        return 0;
    }
}

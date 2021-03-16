package com.ricemarch.cms.pms.service;

import com.ricemarch.cms.pms.entity.UserWorkScheduling;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 排班记录表 服务类
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-16
 */
public interface UserWorkSchedulingService extends IService<UserWorkScheduling> {

    /**
     * 获取用户的排班类型
     *
     * @param userId
     */
    int getUserWorkType(String userId);
}

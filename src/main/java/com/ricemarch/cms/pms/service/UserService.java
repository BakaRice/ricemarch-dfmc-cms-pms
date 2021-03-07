package com.ricemarch.cms.pms.service;

import com.ricemarch.cms.pms.bo.request.InsertBasicUserReq;
import com.ricemarch.cms.pms.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-05
 */
public interface UserService extends IService<User> {

    public void insertBasicUser(InsertBasicUserReq insertBasicUserReq);


}

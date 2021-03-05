package com.ricemarch.cms.pms.service.impl;

import com.ricemarch.cms.pms.entity.User;
import com.ricemarch.cms.pms.mapper.UserMapper;
import com.ricemarch.cms.pms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

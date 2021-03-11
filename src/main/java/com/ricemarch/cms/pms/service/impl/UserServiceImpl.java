package com.ricemarch.cms.pms.service.impl;

import com.ricemarch.cms.pms.bo.request.InsertBasicUserReq;
import com.ricemarch.cms.pms.entity.User;
import com.ricemarch.cms.pms.mapper.UserMapper;
import com.ricemarch.cms.pms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBasicUser(InsertBasicUserReq insertBasicUserReq) {
        User user = new User();
        user.setUsername(insertBasicUserReq.getUsername());
        String gender = insertBasicUserReq.getGender().equals("男") ? "男" : "女";
        user.setGender(gender);
        user.setCreateUser(Optional.ofNullable(insertBasicUserReq.getCreate_user()).orElse(null));
        user.setPhone(insertBasicUserReq.getPhone());
        user.setPassword(encoder.encode(insertBasicUserReq.getPassword()));
        userMapper.insert(user);
    }
}

package com.ricemarch.cms.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ricemarch.cms.pms.bo.request.InsertBasicUserReq;
import com.ricemarch.cms.pms.common.expection.PmsServiceException;
import com.ricemarch.cms.pms.dto.CustomUser;
import com.ricemarch.cms.pms.entity.User;
import com.ricemarch.cms.pms.mapper.UserMapper;
import com.ricemarch.cms.pms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
//        User user1 = userMapper.selectById(createUserId);
//        if (null == user1) {
//            throw new PmsServiceException("新增用户失败，当前登录用户不存在");
//        }
        user.setCreateTime(LocalDateTime.now(ZoneId.of("UTC+8")));
        userMapper.insert(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void UpdateAddressAndPhone(CustomUser customUser, String userId) {
        User updateUser = new User();
        if (StringUtils.isEmpty(userId)) {
            throw new PmsServiceException("无法查询到该用户");
        }
        if (null == customUser || StringUtils.isEmpty(customUser.getAddress())) {
            throw new PmsServiceException("修改参数值不全，无法进行修改");
        }
        updateUser.setId(userId);
        updateUser.setAddress(customUser.getAddress());
//        updateUser.setPhone(customUser.getPhone());
        userMapper.updateById(updateUser);
    }
}

package com.ricemarch.cms.pms.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ricemarch.cms.pms.bo.request.InsertBasicUserReq;
import com.ricemarch.cms.pms.common.enums.BizErrorCodeEnum;
import com.ricemarch.cms.pms.common.enums.PmsBaseErrorCodeEnum;
import com.ricemarch.cms.pms.common.expection.BaseException;
import com.ricemarch.cms.pms.common.expection.PmsServiceException;
import com.ricemarch.cms.pms.common.facade.BaseResponse;
import com.ricemarch.cms.pms.dto.CustomUser;
import com.ricemarch.cms.pms.dto.UserType;
import com.ricemarch.cms.pms.entity.User;
import com.ricemarch.cms.pms.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * <p>
 * 用户 前端控制器，仅对自身进行操作
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/api/pms/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    /**
     * 用于创建用户，用户能自主创建账号，但不会有组织id 和 company
     * <p>
     * 新加权限的设计
     * user_type: default,institution 不能创建新用户。 company 才能创建新用户
     *
     * @param basicUserReq 用户传输对象
     */
    @PostMapping
    public BaseResponse addUser(@Valid @RequestBody InsertBasicUserReq basicUserReq) {
        //TODO 默认user type 的设计和调整
        QueryWrapper<User> qw_phone = new QueryWrapper<User>();
        qw_phone.eq("phone", basicUserReq.getPhone());
        if (userService.getOne(qw_phone) != null) {
            return new BaseResponse(BizErrorCodeEnum.PHONE_NUMBER_HAS_BEEN_USED);
        }
        userService.insertBasicUser(basicUserReq);
        return new BaseResponse();
    }

    /**
     * 用来根据 auth 获取用户信息 通过手机号查找用户信息 并返回
     *
     * @return 用户信息 去除密码等
     */
    @GetMapping("")
    public BaseResponse<CustomUser> getUserByPhone() {
//        //TODO 查询权限的设计 user_type: 普通员工只能查自己 institution leader能查自己institution的内容,company账户能查所有
        QueryWrapper<User> qwPhone = new QueryWrapper<User>();
        String phone = Optional.ofNullable(super.getUserFull().getPhone())
                .orElseThrow(() -> new PmsServiceException("用户不存在，查询被拒绝"));
        qwPhone.eq("phone", phone);
        User one = userService.getOne(qwPhone);
        CustomUser customUser = new CustomUser();
        BeanUtils.copyProperties(one, customUser);
        return new BaseResponse<>(customUser);
    }
}


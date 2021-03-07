package com.ricemarch.cms.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ricemarch.cms.pms.bo.request.InsertBasicUserReq;
import com.ricemarch.cms.pms.common.enums.BizErrorCodeEnum;
import com.ricemarch.cms.pms.common.facade.BaseResponse;
import com.ricemarch.cms.pms.entity.User;
import com.ricemarch.cms.pms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/api/pms/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用于创建用户 注册用户
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

}


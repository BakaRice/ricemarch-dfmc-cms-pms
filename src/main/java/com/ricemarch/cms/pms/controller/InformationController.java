package com.ricemarch.cms.pms.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ricemarch.cms.pms.common.expection.PmsServiceException;
import com.ricemarch.cms.pms.common.facade.BaseResponse;
import com.ricemarch.cms.pms.dto.CustomUser;
import com.ricemarch.cms.pms.entity.User;
import com.ricemarch.cms.pms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 信息管理:
 * 基本信息管理: InformationController
 * 信息修改: 个人信息 就是所谓的基本信息
 * 信息查看:
 *
 * @author RiceMarch
 * @date 2021/3/13 22:26
 */
@RestController
@RequestMapping("/api/info")
@Slf4j
public class InformationController extends BaseController {

    @Autowired
    public UserService userService;

    /**
     * 查询信息 传入手机号 但仅能查询自身信息
     *
     * @param phone
     * @return
     */
    @GetMapping("/user/{phone}")
    public BaseResponse<CustomUser> getInfo(@PathVariable("phone") String phone) {

        log.debug("{}", "GET /api/info/" + phone);
        log.debug("{}", JSON.toJSONString(super.getUserFull()));
        CustomUser customUser = new CustomUser();
        if (!phone.equals(super.getUserFull().getPhone()) || StringUtils.isBlank(phone)) {
            throw new PmsServiceException("当前手机号权限不足或手机号不存在");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        User one = userService.getOne(queryWrapper);
        if (null != one) {
            BeanUtils.copyProperties(one, customUser);
            log.debug("{}", JSON.toJSONString(customUser));
        } else {
            throw new PmsServiceException("query user failed!");
        }

        return new BaseResponse<>(customUser);
    }

    /**
     * 修改个人信息
     * 合理范围 个人只能修改 住址
     *
     * @param customUser
     * @return
     */
    @PostMapping("/user")
    public BaseResponse<CustomUser> postInfo(@RequestBody CustomUser customUser) {
//        userService.update;
        String userId = super.getUserId();
        userService.UpdateAddressAndPhone(customUser, userId);
        //TODO 待使用
        return new BaseResponse<>();
    }

    @GetMapping("/company")
    public BaseResponse getCompany() {
        return new BaseResponse();
    }

    @GetMapping("/institution")
    public BaseResponse getInstitution() {
        return new BaseResponse();
    }


}
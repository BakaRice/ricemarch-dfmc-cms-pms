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
import com.ricemarch.cms.pms.mapper.UserWorkSchedulingMapper;
import com.ricemarch.cms.pms.service.UserService;
import com.ricemarch.cms.pms.service.UserWorkAttendanceService;
import com.ricemarch.cms.pms.service.UserWorkSchedulingService;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/api/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    UserWorkAttendanceService attendanceService;

    @Autowired
    UserWorkSchedulingService schedulingService;

//    /api/user/work/ <- 考勤

    /**
     * 用来根据 auth 获取用户信息 通过手机号查找用户信息 并返回
     * /api/user/info/ <- 信息
     *
     * @return
     */
    @GetMapping("/info")
    public BaseResponse<CustomUser> getUserInfo() {
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

    @GetMapping("/work")
    public BaseResponse getUserWorkInfo() {
        return new BaseResponse();
    }

    /**
     * 考勤打卡
     * 考勤打卡的逻辑上 当前用户在当前日没有上班记录时，则进行打卡上班操作，
     * 下一次打卡操作即视为下班，下次打卡时间未超过8小时时，则视为早退
     *
     * @return
     */
    @PostMapping("/work")
    public BaseResponse addWorkLog() {
        String userId = super.getUserId();
        if (!StringUtils.isEmpty(userId)) {
            //判断排班的类型 获取对应的上班时间 判断是否在合理的考勤时间内
            int type =  schedulingService.getUserWorkType(userId);

            attendanceService.addWorkLog(userId, type);
        }
        return new BaseResponse();
    }
}


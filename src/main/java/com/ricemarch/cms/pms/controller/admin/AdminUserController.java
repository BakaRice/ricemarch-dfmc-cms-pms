package com.ricemarch.cms.pms.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ricemarch.cms.pms.bo.request.InsertBasicUserReq;
import com.ricemarch.cms.pms.common.enums.BizErrorCodeEnum;
import com.ricemarch.cms.pms.common.facade.BaseResponse;
import com.ricemarch.cms.pms.controller.BaseController;
import com.ricemarch.cms.pms.dto.CustomUser;
import com.ricemarch.cms.pms.entity.User;
import com.ricemarch.cms.pms.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 管理权限 创建用户 修改所有用户 删除
 * <p>
 * 提供 Admin Controller来进行统一的权限管理
 * 使用拦截器来进行鉴权
 *
 * @author tanwentao
 * @since 2021/3/11
 */
@RestController
@RequestMapping("/api/pms/admin")
public class AdminUserController extends BaseController {

    @Autowired
    public UserService userService;

    /**
     * 用于创建用户，用户能自主创建账号，但不会有组织id 和 company
     * <p>
     * 新加权限的设计
     * user_type: default,institution 不能创建新用户。 company 才能创建新用户
     *
     * @param basicUserReq 用户传输对象
     */
    @PostMapping
    public BaseResponse<CustomUser> addUser(@Valid @RequestBody InsertBasicUserReq basicUserReq) {
        //TODO 默认user type 的设计和调整
        QueryWrapper<User> qwPhone = new QueryWrapper<User>();
        qwPhone.eq("phone", basicUserReq.getPhone());
        if (userService.getOne(qwPhone) != null) {
            return new BaseResponse(BizErrorCodeEnum.PHONE_NUMBER_HAS_BEEN_USED);
        }
        String createUserId = super.getUserId();
        basicUserReq.setCreate_user(createUserId);
        userService.insertBasicUser(basicUserReq);
        User one = userService.getOne(qwPhone);
        CustomUser customUser = new CustomUser();
        BeanUtils.copyProperties(one, customUser);
        return new BaseResponse(customUser);
    }

    @PostMapping("/role")
    public BaseResponse changeRole() {
        return new BaseResponse();
    }


}

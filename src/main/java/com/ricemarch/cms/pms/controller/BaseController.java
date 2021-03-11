package com.ricemarch.cms.pms.controller;

import com.ricemarch.cms.pms.aspect.UserContextHolder;
import com.ricemarch.cms.pms.dto.CustomUser;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description: Base 控制器用于获取user信息
 * @author: tanwentao
 * @date: 2021/3/8
 */

public class BaseController {

    protected CustomUser getUserFull() {
        return UserContextHolder.getUser();
    }

    protected String getUsername() {
        if (null != this.getUserFull()) {
            String userName = this.getUserFull().getUsername();
            if (StringUtils.isBlank(userName)) {
                userName = this.getUserFull().getUsername();
            }
            return userName;
        }
        return null;
    }

    protected String getUserId() {
        String userId = UserContextHolder.getUserId();
        if (null != userId) {
            return userId;
        }
        return "";
    }
}

package com.ricemarch.cms.pms.aspect;

import com.ricemarch.cms.pms.dto.BaseUser;
import com.ricemarch.cms.pms.dto.CustomUser;

import java.util.Optional;

/**
 * @Description: 当前登录用户持有者
 * @author: tanwentao
 * @date: 2021/3/8
 */

public class UserContextHolder {
    public static final ThreadLocal<CustomUser> userLocal = new ThreadLocal<>();

    public static CustomUser getUser() {
        return userLocal.get();
    }


    /**
     * 设置当前登录用户信息
     *
     * @param user
     */
    public static void setUser(CustomUser user) {
        userLocal.set(user);
    }

    /**
     * 获取当前登录用户名称
     *
     * @return UserName
     */
    public static String getUserName() {
        return Optional.ofNullable(getUser())
                .map(BaseUser::getUsername)
                .orElse(null);
    }
}

package com.ricemarch.cms.pms.component;

import com.ricemarch.cms.pms.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author RiceMarch
 * @date 2021/3/7 17:02
 */
@Data
@AllArgsConstructor
public class MyToken {
    public static final String AUTHORIZATION = "Authorization";
    public static final String PHONE = "phone";
    public static final String ROLE = "role";
    private String phone;
    //TODO ROLE
    private String role;
}
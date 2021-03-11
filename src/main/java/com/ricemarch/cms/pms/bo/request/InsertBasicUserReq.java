package com.ricemarch.cms.pms.bo.request;

import com.ricemarch.cms.pms.dto.UserType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * use for basic user register request
 *
 * @author RiceMarch
 * @date 2021/3/7 16:34
 */
@Data
public class InsertBasicUserReq extends BaseRequest {
    /**
     * 名称
     */
    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "手机号码不能为空")
    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$", message = "手机号码格式有误")
    private String phone;

    @NotNull(message = "性别不能为空")
    private String gender;

    @NotNull(message = "生日不能为空")
    private Date birthday;

    @NotNull(message = "密码不能为空")
    private String password;

    private String userType;

    /**
     * 创建人
     */
    private String create_user;

}

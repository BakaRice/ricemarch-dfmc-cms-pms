package com.ricemarch.cms.pms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ricemarch.cms.pms.bo.request.LoginReq;
import com.ricemarch.cms.pms.bo.response.LoginResp;
import com.ricemarch.cms.pms.common.facade.BaseResponse;
import com.ricemarch.cms.pms.component.EncryptComponent;
import com.ricemarch.cms.pms.component.MyToken;
import com.ricemarch.cms.pms.entity.User;
import com.ricemarch.cms.pms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author RiceMarch
 * @date 2021/3/7 18:48
 */
@RestController
@Slf4j
@RequestMapping("/api/login")
public class LoginController {

    //    @Value("${cms.teacher}")
//    private String roleTeacher;
//    @Value("${cms.student}")
//    private String roleStudent;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private EncryptComponent encrypt;

    @Autowired
    private UserService userService;


    @PostMapping
    public BaseResponse<LoginResp> login(@RequestBody LoginReq loginReq, HttpServletResponse response) {
        loginReq = Optional.ofNullable(loginReq)
                .orElseThrow((() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名或密码错误")));
        if (loginReq.getPhone() == null || loginReq.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名或密码不能为空");
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phone", loginReq.getPhone());
        String reqPwd = loginReq.getPassword();
        User user = Optional.ofNullable(userService.getOne(wrapper))
                .filter(u -> encoder.matches(reqPwd, u.getPassword()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名或密码错误"));
//
        MyToken token = new MyToken(user.getPhone(), user.getUserType());
        String auth = encrypt.encryptToken(token);
        response.setHeader(MyToken.AUTHORIZATION, auth);//键值对 不要用硬编码 用常量 避免书写错误等情况
//        String roleCode = user.getRole() == User.Role.TEACHER ? roleTeacher : roleStudent;
        //TODO ROLECODE 实现 <-- user-type
        String roleCode = user.getUserType();
        LoginResp loginResp = new LoginResp();
        loginResp.setRole(roleCode);
        return new BaseResponse<>(loginResp);
    }
}

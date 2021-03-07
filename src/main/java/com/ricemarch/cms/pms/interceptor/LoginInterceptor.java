package com.ricemarch.cms.pms.interceptor;

import com.ricemarch.cms.pms.component.EncryptComponent;
import com.ricemarch.cms.pms.component.MyToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author RiceMarch
 * @date 2021/3/7 17:06
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private EncryptComponent encryptComponent;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MyToken myToken = Optional.ofNullable(request.getHeader(MyToken.AUTHORIZATION))
                .map(auth -> encryptComponent.decryptToken(auth))
                .orElseThrow((() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "登录失败")));
        String uid = Optional.of(myToken.getPhone())
                .orElseThrow((() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "登录失败")));
        String role = Optional.of(myToken.getRole())
                .orElseThrow((() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "登录失败")));
        request.setAttribute(MyToken.PHONE, uid);
        request.setAttribute(MyToken.ROLE, role);
        return true;
    }
}

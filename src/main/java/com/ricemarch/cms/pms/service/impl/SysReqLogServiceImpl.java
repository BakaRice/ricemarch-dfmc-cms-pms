package com.ricemarch.cms.pms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ricemarch.cms.pms.bo.request.BaseRequest;

import com.ricemarch.cms.pms.common.component.EncryptComponent;
import com.ricemarch.cms.pms.common.component.MyToken;
import com.ricemarch.cms.pms.entity.SysReqLog;
import com.ricemarch.cms.pms.entity.User;
import com.ricemarch.cms.pms.mapper.SysReqLogMapper;
import com.ricemarch.cms.pms.service.SysReqLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ricemarch.cms.pms.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.Random;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-05
 */
@Service
public class SysReqLogServiceImpl extends ServiceImpl<SysReqLogMapper, SysReqLog> implements SysReqLogService {

    @Autowired
    private EncryptComponent encryptComponent;

    @Autowired
    private UserService userService;

    @Override
    @Async("asyncServiceExecutor")
    public void save(ProceedingJoinPoint pjp, ServletRequestAttributes sra, long time, Object proceed) {
        assert sra != null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        String s = Optional.ofNullable(request.getRequestURL()).orElse(new StringBuffer()).toString();
        String url = s;
        String method = request.getMethod();
        //TODO store id
        Random random = new Random();
        SysReqLog sysReqLog = new SysReqLog();
        if (pjp.getArgs().length != 0) {
            BaseRequest arg = (BaseRequest) pjp.getArgs()[0];
            sysReqLog.setReqparams(JSON.toJSONString(arg));
//            String userId = Optional.ofNullable(arg.getUserId()).orElse("login");
        }

        sysReqLog.setStoreId(random.nextLong());
        String token = request.getHeader(MyToken.AUTHORIZATION);
        if (StringUtils.isNotBlank(token)) {
            sysReqLog.setToken(token);
            MyToken myToken = encryptComponent.decryptToken(token);
            String phone = myToken.getPhone();
            QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
            queryWrapper.eq("phone", phone);
            Optional.ofNullable(userService.getOne(queryWrapper)).ifPresent(u -> {
                sysReqLog.setUsername(u.getUsername());
                sysReqLog.setUserId(Long.valueOf(u.getId()));
                sysReqLog.setRequestid(u.getPhone());
            });
        }
        sysReqLog.setToken(token);
        sysReqLog.setRequri(url);
        sysReqLog.setMethod(method);
        sysReqLog.setCreatetime(LocalDateTime.now(ZoneId.of("+08:00")));

        sysReqLog.setResparams(JSON.toJSONString(proceed));
        sysReqLog.setTime(Long.toString(time));
        this.save(sysReqLog);

    }
}

package com.ricemarch.cms.pms.service.impl;

import com.alibaba.fastjson.JSON;
import com.ricemarch.cms.pms.entity.SysReqLog;
import com.ricemarch.cms.pms.mapper.SysReqLogMapper;
import com.ricemarch.cms.pms.service.SysReqLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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


    @Override
    @Async("asyncServiceExecutor")
    public void save(ProceedingJoinPoint pjp, ServletRequestAttributes sra, long time, Object proceed) {
        assert sra != null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        //TODO store id
        Random random = new Random();

        String s = JSON.toJSONString(pjp.getArgs());
        SysReqLog sysReqLog = new SysReqLog();
        sysReqLog.setStoreId(random.nextLong());
        sysReqLog.setToken(pjp.getTarget().getClass().getName());
        sysReqLog.setRequri(url);
        sysReqLog.setMethod(method);
        sysReqLog.setReqparams(s);
        sysReqLog.setRequestid(random.ints().toString());
        sysReqLog.setCreatetime(LocalDateTime.now(ZoneId.of("+08:00")));

        sysReqLog.setResparams(JSON.toJSONString(proceed));
        sysReqLog.setTime(Long.toString(time));
        this.save(sysReqLog);

    }
}

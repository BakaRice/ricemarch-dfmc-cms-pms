package com.ricemarch.cms.pms.aspect;

import com.alibaba.fastjson.JSON;
import com.ricemarch.cms.pms.entity.SysReqLog;
import com.ricemarch.cms.pms.service.SysReqLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author RiceMarch
 * @date 2021/3/5 21:26
 */
@Aspect
@Component
@Slf4j
public class ReqAspect {

    @Autowired
    SysReqLogService sysReqLogService;
    

    @Pointcut("execution(* com.ricemarch.cms.pms.controller..*.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object beforeAdvice(ProceedingJoinPoint pjp) throws Throwable {
        log.info("{}", pjp.getTarget().getClass().getName());
        long startTime = System.currentTimeMillis();
        //从requestContextHolder中获取 request attributes
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //将给定的RequestAttributes绑定到当前线程
        RequestContextHolder.setRequestAttributes(sra, true);
        Object proceed = pjp.proceed();
        long time = System.currentTimeMillis() - startTime;
        sysReqLogService.save(pjp,sra,time,proceed);
        return proceed;

    }
}

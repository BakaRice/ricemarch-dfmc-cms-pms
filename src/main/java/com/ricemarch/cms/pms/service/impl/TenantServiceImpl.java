package com.ricemarch.cms.pms.service.impl;

import com.ricemarch.cms.pms.entity.Tenant;
import com.ricemarch.cms.pms.mapper.TenantMapper;
import com.ricemarch.cms.pms.service.TenantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户，谁租用了这个系统 服务实现类
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-05
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements TenantService {

}

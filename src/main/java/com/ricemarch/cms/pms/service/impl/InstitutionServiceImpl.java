package com.ricemarch.cms.pms.service.impl;

import com.ricemarch.cms.pms.entity.Institution;
import com.ricemarch.cms.pms.mapper.InstitutionMapper;
import com.ricemarch.cms.pms.service.InstitutionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 机构（车间，检查班，仓库等） 服务实现类
 * </p>
 *
 * @author ricemarch
 * @since 2021-03-05
 */
@Service
public class InstitutionServiceImpl extends ServiceImpl<InstitutionMapper, Institution> implements InstitutionService {

}

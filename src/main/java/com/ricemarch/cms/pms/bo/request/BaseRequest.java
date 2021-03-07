package com.ricemarch.cms.pms.bo.request;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author RiceMarch
 * @date 2021/3/7 20:05
 */
@Data
@Slf4j
public class BaseRequest implements Serializable {

    private static final long serialVersionUID = 937416093630936160L;
    /**
     * 用户id
     */
    private String userId;
}

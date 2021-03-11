package com.ricemarch.cms.pms.dto;

public enum UserType {
    /**
     * 默认员工
     */
    DEFAULT("default"),
    /**
     * 机构员工
     */
    INSTITUTION("institution"),
    /**
     * 公司
     */
    COMPANY("company"),
    /**
     * 最高权限
     */
    TENANT("tenant");
    /**
     * 员工类型
     */
    private final String TYPE;

    UserType(String type) {
        TYPE = type;
    }

    public String getType() {
        return TYPE;
    }
}

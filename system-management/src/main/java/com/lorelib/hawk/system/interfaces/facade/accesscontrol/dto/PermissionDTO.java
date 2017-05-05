package com.lorelib.hawk.system.interfaces.facade.accesscontrol.dto;

import com.lorelib.hawk.infrastructure.stereotype.DTO;

/**
 * @author listening
 * @description PermissionDTO:
 * @create 2017 04 13 13:36.
 */
public class PermissionDTO implements DTO {
    /**
     * 资源标识
     */
    private Long resourceId;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 资源类型
     */
    private String resourceType;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
}

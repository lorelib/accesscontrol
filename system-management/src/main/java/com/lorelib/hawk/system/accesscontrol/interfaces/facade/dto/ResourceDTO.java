package com.lorelib.hawk.system.accesscontrol.interfaces.facade.dto;

import com.lorelib.hawk.system.menu.infrastructure.type.ResourceType;
import com.lorelib.hawk.infrastructure.stereotype.DTO;

import javax.validation.constraints.NotNull;

/**
 * @author listening
 * @description ResourceDTO:
 * @create 2017 04 18 11:17.
 */
public class ResourceDTO implements DTO {
    /**
     * 资源标识
     */
    @NotNull(message = "资源ID是必需的")
    private Long resourceId;

    /**
     * 资源名称
     */
    @NotNull(message = "资源名称是必需的")
    private String resourceName;

    /**
     * 资源类型
     */
    @NotNull(message = "资源类型是必需的")
    private String resourceType;

    public ResourceDTO() {
    }

    public ResourceDTO(ResourceType resourceType, Long resourceId) {
        this.resourceType = resourceType.name();
        this.resourceId = resourceId;
    }

    public ResourceDTO(ResourceType resourceType, Long resourceId, String resourceName) {
        this(resourceType, resourceId);
        this.resourceName = resourceName;
    }

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

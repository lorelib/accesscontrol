package com.lorelib.hawk.system.accesscontrol.domain;

import com.lorelib.hawk.system.menu.ResourceType;
import com.lorelib.hawk.infrastructure.stereotype.ValueObject;

/**
 * @author listening
 * @description Resource:
 * @create 2017 04 12 11:47.
 */
public final class Resource extends ValueObject {
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

    protected Resource() {

    }

    public Resource(ResourceType resourceType, Long resourceId, String resourceName) {
        this.resourceType = resourceType.name();
        this.resourceId = resourceId;
        this.resourceName = resourceName;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (!resourceId.equals(resource.resourceId)) return false;
        return resourceType.equals(resource.resourceType);
    }

    @Override
    public int hashCode() {
        int result = resourceId.hashCode();
        result = 31 * result + resourceType.hashCode();
        return result;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
}

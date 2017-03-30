package com.lorelib.hawk.accesscontrol.domain.access;

import com.lorelib.hawk.infrastructure.stereotype.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 资源
 * Created by listening on 2017/3/7.
 */
@Entity
@Table(name = "ac_resource")
public class Resource extends BaseEntity {
    /**
     * 父级资源ID
     */
    private long parentId;
    /**
     * 资源类型
     */
    @NotNull(message = "资源类型为空")
    private String resourceType;

    /**
     * 资源名称
     */
    @NotNull(message = "资源名称为空")
    private String resourceName;

    /**
     * 资源路径
     */
    @NotNull(message = "资源路径为空")
    private String resourcePath;

    /**
     * 资源拥有的子资源
     */
    @Valid
    private List<Resource> subResources;

    public Resource() {
        super();
    }

    public Resource(String resourceType, String resourceName, String resourcePath) {
        this();
        this.resourceType = resourceType;
        this.resourceName = resourceName;
        this.resourcePath = resourcePath;
    }

    public Resource(long parentId, String resourceType, String resourceName, String resourcePath) {
        this(resourceType, resourceName, resourcePath);
        this.parentId = parentId;
    }

    public String resourceType() {
        return this.resourceType;
    }

    public Resource subResources(List<Resource> subResources) {
        this.subResources = subResources;
        return this;
    }

    public List<Resource> subResources() {
        return this.subResources;
    }

    public Resource withoutSubResources() {
        try {
            Resource clone = (Resource) this.clone();
            return clone.subResources(null);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("对象[" + this.getClass().getName() + "]克隆失败", e);
        }
    }
}

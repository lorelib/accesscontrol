package com.lorelib.accesscontrol.domain.access;

import com.lorelib.accesscontrol.infrastructure.stereotype.BaseEntity;

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
     * 资源拥有的操作
     */
    @Valid
    private List<Operation> opts;

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
    }

    public String resourceType() {
        return this.resourceType;
    }

    public Resource opts(List<Operation> opts) {
        this.opts = opts;
        return this;
    }

    public List<Operation> opts() {
        return this.opts;
    }
}

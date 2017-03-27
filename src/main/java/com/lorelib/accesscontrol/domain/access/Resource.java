package com.lorelib.accesscontrol.domain.access;

import com.lorelib.accesscontrol.commons.algorithm.IdGenerator;
import com.lorelib.accesscontrol.commons.stereotype.Entity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 资源
 * Created by listening on 2017/3/7.
 */
public class Resource extends Entity {
    /**
     * 外部资源ID
     */
    @Min(value = 1, message = "资源ID为空")
    private long outResourceId;

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
    @NotNull(message = "资源操作为null")
    @Size(min = 1, message = "资源操作为空")
    private List<Operation> opts;

    public Resource() {
        super();
        this.setId(IdGenerator.nextId());
    }

    public Resource(String resourceType, String resourceName, String resourcePath) {
        this();
        this.resourceType = resourceType;
        this.resourceName = resourceName;
        this.resourcePath = resourcePath;
    }

    public Resource outResourceId(long outResourceId) {
        this.outResourceId = outResourceId;
        return this;
    }

    public Resource opts(List<Operation> opts) {
        this.opts = opts;
        return this;
    }

    public long getOutResourceId() {
        return outResourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public List<Operation> getOpts() {
        return opts;
    }
}

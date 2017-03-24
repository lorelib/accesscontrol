package com.lorelib.accesscontrol.domain;

import com.lorelib.accesscontrol.commons.algorithm.IdGenerator;
import com.lorelib.accesscontrol.commons.stereotype.Entity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * 资源
 * Created by listening on 2017/3/7.
 */
public class Resource extends Entity {
    /**
     * 公司信息
     */
    @Valid
    private CompanyInfo companyInfo;

    /**
     * 外部资源ID
     */
    @Min(value = 1, message = "资源ID为空")
    private int outResourceId;

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
    private Set<Operation> opts = new HashSet<>();

    public Resource() {
        super();
        this.setId(IdGenerator.nextId());
    }

    public Resource(int outResourceId, String resourceType, String resourceName, String resourcePath) {
        this();
        this.outResourceId = outResourceId;
        this.resourceType = resourceType;
        this.resourceName = resourceName;
        this.resourcePath = resourcePath;
    }

    public Integer outResourceId() {
        return this.outResourceId;
    }

    public Resource companyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
        return this;
    }

    public Resource opts(Set<Operation> opts) {
        this.opts = opts;
        return this;
    }
}

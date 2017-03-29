package com.lorelib.accesscontrol.domain.access;

import com.lorelib.accesscontrol.infrastructure.helpers.algorithm.IdGenerator;
import com.lorelib.accesscontrol.infrastructure.stereotype.Entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 操作
 * Created by listening on 2017/3/7.
 */
public class Operation extends Entity {
    /**
     * 资源ID
     */
    @Min(value = 1, message = "资源ID为空")
    private long resourceId;

    /**
     * 操作名称
     */
    @NotNull(message = "操作名称为空")
    private String optName;

    /**
     * 操作路径
     */
    @NotNull(message = "操作路径为空")
    private String optPath;

    public Operation() {
        super();
        this.setId(IdGenerator.nextId());
    }

    public Operation(long resourceId, String optName, String optPath) {
        this();
        this.resourceId = resourceId;
        this.optName = optName;
        this.optPath = optPath;
    }
}

package com.lorelib.accesscontrol.domain;

import com.lorelib.accesscontrol.commons.stereotype.Entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by listening on 2017/3/7.
 */
public class Operation extends Entity {
    /**
     * 资源ID
     */
    @Min(value = 1, message = "资源ID为空")
    private int resourceId;

    /**
     * 操作ID
     */
    private int optId;
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
    }

    public Operation(int resourceId, String optName, String optPath) {
        this();
        this.resourceId = resourceId;
        this.optName = optName;
        this.optPath = optPath;
    }
}

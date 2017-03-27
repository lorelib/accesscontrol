package com.lorelib.accesscontrol.domain.access;

import com.lorelib.accesscontrol.commons.stereotype.Entity;

/**
 * 权限
 * Created by listening on 2017/3/7.
 */
public class Permission extends Entity {
    /**
     * 拥有的资源
     */
    private Resource resource;

    /**
     * 拥有的操作
     */
    private Operation opt;
}

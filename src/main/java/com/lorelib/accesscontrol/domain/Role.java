package com.lorelib.accesscontrol.domain;

import com.lorelib.accesscontrol.commons.stereotype.Entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色
 * Created by listening on 2017/3/7.
 */
public class Role extends Entity {
    /**
     * 公司信息
     */
    private CompanyInfo companyInfo;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色拥有的权限
     */
    private Set<Permission> permissions = new HashSet<>();

    public Role() {
        super();
    }
}

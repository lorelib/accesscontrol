package com.lorelib.accesscontrol.domain;

import com.lorelib.accesscontrol.commons.stereotype.Entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 * Created by listening on 2017/3/7.
 */
public class User extends Entity {
    /**
     * 公司信息
     */
    private CompanyInfo companyInfo;

    /**
     * 用户登录帐号
     */
    private String userLoginId;

    /**
     * 用户拥有的权限
     */
    private Set<Role> roles = new HashSet<>();

    public User() {
        super();
    }
}

package com.lorelib.hawk.accesscontrol.domain;

import com.lorelib.hawk.infrastructure.stereotype.DomainService;
import org.testng.collections.Lists;

import java.util.List;

/**
 * 授权服务
 * Created by listening on 2017/3/24.
 */
@DomainService
public class AuthorizationService {
    /**
     * 为用户分配角色
     * @param user
     * @param role
     */
    public void assignRoleTo(User user, Role role) {

    }

    /**
     * 取消用户角色
     * @param user
     * @param role
     */
    public void unassignRoleFor(User user, Role role) {

    }

    /**
     * 获取用户角色
     * @param user
     * @return
     */
    public List<Role> getRolesFor(User user) {
        return Lists.newArrayList();
    }
}

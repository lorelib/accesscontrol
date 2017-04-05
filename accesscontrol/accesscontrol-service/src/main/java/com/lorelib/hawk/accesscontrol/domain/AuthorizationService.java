package com.lorelib.hawk.accesscontrol.domain;

import com.lorelib.hawk.infrastructure.stereotype.DomainService;
import org.springframework.beans.factory.annotation.Autowired;

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
     * @param roles
     */
    public void assignRoleTo(User user, List<Role> roles) {
        userRepository.addRoleTo(user.addRoles(roles));
    }

    /**
     * 取消用户角色
     * @param user
     * @param roles
     */
    public void unassignRoleFor(User user, List<Role> roles) {
        userRepository.deleteRoleFor(user.addRoles(roles));
    }

    /**
     * 获取用户角色
     * @param user
     * @return
     */
    public List<Role> getRolesFor(User user) {
        return userRepository.getRolesFor(user);
    }

    @Autowired
    private UserRepository userRepository;
}

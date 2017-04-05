package com.lorelib.hawk.accesscontrol.domain;

import com.lorelib.hawk.infrastructure.stereotype.BaseRepository;

import java.util.List;

/**
 * Created by listening on 2017/4/1.
 */
public interface UserRepository extends BaseRepository {
    /**
     * 添加用户角色
     * @param user
     */
    void addRoleTo(User user);

    /**
     * 更新用户角色
     * @param user
     */
    void updateRoleFor(User user);

    /**
     * 删除用户角色
     * @param user
     */
    void deleteRoleFor(User user);

    /**
     * 获取用户角色
     * @param user
     * @return
     */
    List<Role> getRolesFor(User user);
}

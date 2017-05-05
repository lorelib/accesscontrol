package com.lorelib.hawk.system.domain.accesscontrol;

import com.google.common.collect.Lists;
import com.lorelib.hawk.infrastructure.helpers.algorithm.IdGenerator;
import com.lorelib.hawk.infrastructure.stereotype.DomainEntity;
import org.apache.commons.lang3.Validate;

import java.util.List;

/**
 * @author listening
 * @description Role: 角色
 * @create 2017 03 24 11:09.
 */
public class Role extends DomainEntity<Role, RoleId> {
    /**
     * 标识
     */
    private RoleId id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 描述（简介）
     */
    private String description;

    /**
     * 角色拥有的权限
     */
    private List<Permission> perms;

    /**
     * 需要新增的
     */
    private List<Permission> needAdd;

    /**
     * 需要删除的
     */
    private List<Permission> needDel;

    public Role() {
        super();
    }

    public Role(RoleId id, String roleName, String description) {
        this();
        Validate.notNull(id, "角色标识是必需的");
        Validate.notBlank(roleName, "角色名称是必需的");
        this.id = id;
        this.roleName = roleName;
        this.description = description;
    }

    /**
     * 新增权限
     * @param resources
     * @return
     */
    public void addPerms(final List<Resource> resources) {
        List<Permission> perms = Lists.newArrayList();
        for (Resource resource: resources) {
            Permission perm = new Permission(IdGenerator.nextId(), this.id, resource);
            perms.add(perm);
        }
        this.perms = perms;
    }

    /**
     * 更新权限
     * @param resources
     */
    public void updatePerms(final List<Resource> resources) {
        Validate.notEmpty(resources, "资源是必需的");
        List<Permission> needAdd = Lists.newArrayList();
        List<Permission> needDel = Lists.newArrayList();
        List<Resource> owneds = getOwnedResources();

        for (Resource update: resources) {
            if (!owneds.contains(update)){
                needAdd.add(new Permission(IdGenerator.nextId(), this.id, update));
            }
        }
        this.needAdd = needAdd;

        for (Permission perm: getPerms()) {
            if (!resources.contains(perm.getResource())) {
                needDel.add(perm);
            }
        }
        this.needDel = needDel;
    }

    protected List<Resource> getOwnedResources() {
        List<Resource> owned = Lists.newArrayList();
        List<Permission> perms = this.getPerms();
        for (Permission perm: perms) {
            owned.add(perm.getResource());
        }
        return owned;
    }

    public Role desc(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean sameIdentityAs(Role other) {
        return other != null && this.id.equals(other.id);
    }

    @Override
    public RoleId getId() {
        return this.id;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDescription() {
        return description;
    }

    public List<Permission> getPerms() {
        return perms;
    }

    public List<Permission> getNeedAdd() {
        return needAdd;
    }

    public List<Permission> getNeedDel() {
        return needDel;
    }

    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPerms(List<Permission> perms) {
        this.perms = perms;
    }

    public void setNeedAdd(List<Permission> needAdd) {
        this.needAdd = needAdd;
    }

    public void setNeedDel(List<Permission> needDel) {
        this.needDel = needDel;
    }
}

package com.lorelib.hawk.system.accesscontrol.domain;

import com.lorelib.hawk.infrastructure.stereotype.DomainEntity;
import org.apache.commons.lang3.Validate;

/**
 * @author listening
 * @description Permission: 权限
 * @create 2017 03 24 11:09.
 */
public class Permission extends DomainEntity<Permission, Long> {
    /**
     * 标识，象征性的标识，不做具体使用
     */
    private Long id;

    /**
     * 角色
     */
    private RoleId roleId;

    /**
     * 资源
     */
    private Resource resource;

    public Permission() {
        super();
    }

    public Permission(Long id, RoleId roleId, Resource resource) {
        this();
        Validate.notNull(id, "权限标识是必需的");
        Validate.notNull(roleId, "角色标识是必需的");
        Validate.notNull(resource, "资源是必需的");
        this.id = id;
        this.roleId = roleId;
        this.resource = resource;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    protected boolean sameIdentityAs(final Permission other) {
        return other != null && roleId.equals(other.roleId) && resource.equals(other.resource);
    }

    @Override
    public int hashCode() {
        int result = roleId.hashCode();
        result = 31 * result + resource.hashCode();
        return result;
    }

    public RoleId getRoleId() {
        return roleId;
    }

    public Resource getResource() {
        return resource;
    }
}

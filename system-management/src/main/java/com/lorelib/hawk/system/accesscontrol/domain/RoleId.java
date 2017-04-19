package com.lorelib.hawk.system.accesscontrol.domain;

import com.lorelib.hawk.infrastructure.stereotype.ValueObject;
import org.apache.commons.lang3.Validate;

/**
 * @author listening
 * @description RoleId:
 * @create 2017 04 12 11:33.
 */
public final class RoleId extends ValueObject {
    private final Long id;

    protected RoleId() {
        this.id = 0L;
    }

    public RoleId(Long id) {
        Validate.notNull(id, "角色标识是必需的");
        this.id = id;
    }

    public Long idValue() {
        return this.id;
    }

    @Deprecated
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleId roleId = (RoleId) o;

        return id.equals(roleId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

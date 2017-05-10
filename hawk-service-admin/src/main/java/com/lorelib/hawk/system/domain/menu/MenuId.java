package com.lorelib.hawk.system.domain.menu;

import com.lorelib.hawk.infrastructure.stereotype.ValueObject;
import org.apache.commons.lang3.Validate;

/**
 * @author listening
 * @description MenuId:
 * @create 2017 04 11 13:44.
 */
public final class MenuId extends ValueObject {
    private final Long id;

    protected MenuId() {
        this.id = 0L;
    }

    public MenuId(Long id) {
        Validate.notNull(id, "菜单标识是必需的");
        this.id = id;
    }

    public Long idValue() {
        return id;
    }

    public Long getId() {
        return id;
    }
}

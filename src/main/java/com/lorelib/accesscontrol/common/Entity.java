package com.lorelib.accesscontrol.common;

import java.io.Serializable;

/**
 * 实体
 * Created by listening on 2017/3/16.
 */
public class Entity implements Serializable {
    private long id;

    protected Entity() {
        setId(-1);
    }

    protected long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }
}

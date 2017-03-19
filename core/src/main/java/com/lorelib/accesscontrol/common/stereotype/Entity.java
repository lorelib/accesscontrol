package com.lorelib.accesscontrol.common.stereotype;

import java.io.Serializable;

/**
 * 实体
 * Created by listening on 2017/3/16.
 */
public class Entity implements Serializable {
    private Serializable id;

    protected Entity() {
        setId(-1);
    }

    protected Serializable getId() {
        return id;
    }

    protected void setId(Serializable id) {
        this.id = id;
    }
}

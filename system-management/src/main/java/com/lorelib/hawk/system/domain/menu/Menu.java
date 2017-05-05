package com.lorelib.hawk.system.domain.menu;

import com.lorelib.hawk.infrastructure.stereotype.DomainEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author listening
 * @description Menu: 菜单领域模型
 * @create 2017 04 10 11:41.
 */
public class Menu extends DomainEntity<Menu, MenuId> {
    /**
     * 根节点
     */
    public final static int DEFAULT_ROOT_NODE = -1;

    /**
     * 标识
     */
    private MenuId id;

    /**
     * 父节点
     */
    private MenuId parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单别名，英文名称
     */
    private String menuAlias;

    /**
     * 描述（简介）
     */
    private String description;

    /**
     * 子节点
     */
    private List<Menu> child = new ArrayList<>();

    /**
     * 是否叶子节点
     */
    private boolean isLeaf;

    public boolean isLeaf() {
        return child.size() > 0 ? false : true;
    }

    @Override
    public boolean sameIdentityAs(final Menu other) {
        return other != null && this.id.equals(other.id);
    }

    @Override
    public MenuId getId() {
        return this.id;
    }

    public MenuId getParentId() {
        return parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuAlias() {
        return menuAlias;
    }

    public String getDescription() {
        return description;
    }

    public List<Menu> getChild() {
        return child;
    }
}

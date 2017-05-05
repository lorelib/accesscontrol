package com.lorelib.hawk.system.interfaces.facade.menu.dto;

import com.lorelib.hawk.infrastructure.stereotype.DTO;

import java.util.List;

/**
 * @author listening
 * @description MenuDTO:
 * @create 2017 04 10 16:57.
 */
public class MenuDTO implements DTO {
    private Long id;

    /**
     * 父节点
     */
    private Long parentId;

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
    private List<MenuDTO> child;

    /**
     * 是否叶子节点
     */
    private boolean isLeaf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuAlias() {
        return menuAlias;
    }

    public void setMenuAlias(String menuAlias) {
        this.menuAlias = menuAlias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MenuDTO> getChild() {
        return child;
    }

    public void setChild(List<MenuDTO> child) {
        this.child = child;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
}

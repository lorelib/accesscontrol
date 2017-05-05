package com.lorelib.hawk.system.interfaces.facade.menu.assembler;

import com.lorelib.hawk.system.domain.menu.Menu;
import com.lorelib.hawk.system.interfaces.facade.menu.dto.MenuDTO;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author listening
 * @description MenuDTOAssembler:
 * @create 2017 04 11 20:01.
 */
public final class MenuDTOAssembler {
    public static MenuDTO toDTO(final Menu menu) {
        final MenuDTO dto = new MenuDTO();
        dto.setId(menu.getId().idValue());
        dto.setParentId(menu.getParentId().idValue());
        dto.setMenuName(menu.getMenuName());
        dto.setMenuAlias(menu.getMenuAlias());
        dto.setDescription(menu.getDescription());

        List<MenuDTO> childDTOs = new ArrayList<>();
        List<Menu> child = menu.getChild();
        if (CollectionUtils.isNotEmpty(child)) {
            for (Menu m : child) {
                childDTOs.add(toDTO(m));
            }
        }
        dto.setChild(childDTOs);
        return dto;
    }

    public static List<MenuDTO> toDTO(final List<Menu> menus) {
        final List<MenuDTO> dtos = new ArrayList<>();
        for (Menu menu: menus) {
            dtos.add(toDTO(menu));
        }
        return dtos;
    }
}

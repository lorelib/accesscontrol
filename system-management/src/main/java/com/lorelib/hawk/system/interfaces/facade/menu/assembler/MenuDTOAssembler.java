package com.lorelib.hawk.system.interfaces.facade.menu.assembler;

import com.lorelib.hawk.system.domain.menu.Menu;
import com.lorelib.hawk.system.interfaces.facade.menu.dto.MenuDto;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author listening
 * @description MenuDTOAssembler:
 * @create 2017 04 11 20:01.
 */
public final class MenuDTOAssembler {
    public static MenuDto toDTO(final Menu menu) {
        final MenuDto dto = new MenuDto();
        dto.setId(menu.getId().idValue());
        dto.setParentId(menu.getParentId().idValue());
        dto.setMenuName(menu.getMenuName());
        dto.setMenuAlias(menu.getMenuAlias());
        dto.setDescription(menu.getDescription());

        List<MenuDto> childDTOs = new ArrayList<>();
        List<Menu> child = menu.getChild();
        if (CollectionUtils.isNotEmpty(child)) {
            for (Menu m : child) {
                childDTOs.add(toDTO(m));
            }
        }
        dto.setChild(childDTOs);
        return dto;
    }

    public static List<MenuDto> toDTO(final List<Menu> menus) {
        final List<MenuDto> dtos = new ArrayList<>();
        for (Menu menu: menus) {
            dtos.add(toDTO(menu));
        }
        return dtos;
    }
}

package com.lorelib.hawk.system.interfaces.facade.accesscontrol.assembler;

import com.lorelib.hawk.system.domain.accesscontrol.Role;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.dto.RoleDTO;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * @author listening
 * @description RoleDTOAssembler:
 * @create 2017 04 13 13:42.
 */
public class RoleDTOAssembler {
    public static RoleDTO toDTO(final Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(String.valueOf(role.getId().idValue()));
        dto.setRoleName(role.getRoleName());
        dto.setDescription(role.getDescription());
        if (CollectionUtils.isNotEmpty(role.getPerms())) dto.setPerms(PermissionDTOAssembler.toDTO(role.getPerms()));
        return dto;
    }

    public static List<RoleDTO> toDTO(final List<Role> roles) {
        List<RoleDTO> list = Lists.newArrayList();
        for (Role role: roles) {
            list.add(toDTO(role));
        }
        return list;
    }
}

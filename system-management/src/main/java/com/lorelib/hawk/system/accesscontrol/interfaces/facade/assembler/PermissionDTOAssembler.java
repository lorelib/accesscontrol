package com.lorelib.hawk.system.accesscontrol.interfaces.facade.assembler;

import com.lorelib.hawk.system.accesscontrol.domain.Permission;
import com.lorelib.hawk.system.accesscontrol.domain.Resource;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.dto.PermissionDTO;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author listening
 * @description PermissionDTOAssembler:
 * @create 2017 04 13 13:48.
 */
public class PermissionDTOAssembler {
    public static PermissionDTO toDTO(final Permission perm) {
        PermissionDTO dto = new PermissionDTO();
        Resource resource = perm.getResource();
        if (resource != null) {
            dto.setResourceId(resource.getResourceId());
            dto.setResourceName(resource.getResourceName());
            dto.setResourceType(resource.getResourceType());
        }
        return dto;
    }

    public static List<PermissionDTO> toDTO(final List<Permission> perms) {
        List<PermissionDTO> list = Lists.newArrayList();
        for (Permission perm: perms) {
            list.add(toDTO(perm));
        }
        return list;
    }
}

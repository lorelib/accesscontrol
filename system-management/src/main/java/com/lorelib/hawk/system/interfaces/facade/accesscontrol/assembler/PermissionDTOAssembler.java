package com.lorelib.hawk.system.interfaces.facade.accesscontrol.assembler;

import com.lorelib.hawk.system.domain.accesscontrol.Permission;
import com.lorelib.hawk.system.domain.accesscontrol.Resource;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.dto.PermissionDto;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author listening
 * @description PermissionDTOAssembler:
 * @create 2017 04 13 13:48.
 */
public class PermissionDTOAssembler {
    public static PermissionDto toDTO(final Permission perm) {
        PermissionDto dto = new PermissionDto();
        Resource resource = perm.getResource();
        if (resource != null) {
            dto.setResourceId(resource.getResourceId());
            dto.setResourceName(resource.getResourceName());
            dto.setResourceType(resource.getResourceType());
        }
        return dto;
    }

    public static List<PermissionDto> toDTO(final List<Permission> perms) {
        List<PermissionDto> list = Lists.newArrayList();
        for (Permission perm: perms) {
            list.add(toDTO(perm));
        }
        return list;
    }
}

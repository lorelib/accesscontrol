package com.lorelib.hawk.system.interfaces.facade.accesscontrol;

import com.lorelib.hawk.infrastructure.helpers.query.Criteria;
import com.lorelib.hawk.infrastructure.helpers.query.Page;
import com.lorelib.hawk.infrastructure.helpers.query.PageList;
import com.lorelib.hawk.system.application.RoleService;
import com.lorelib.hawk.system.domain.accesscontrol.Resource;
import com.lorelib.hawk.system.domain.accesscontrol.Role;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.assembler.RoleDTOAssembler;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.CreateRoleCommand;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.CreateRoleWithPermCommand;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.DeleteRoleCommand;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.UpdateRoleCommand;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.dto.RoleDTO;
import com.lorelib.hawk.infrastructure.helpers.mapper.BeanMapper;
import com.lorelib.hawk.infrastructure.helpers.utils.ParamsValidatorUtil;
import com.lorelib.hawk.infrastructure.stereotype.Facade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author listening
 * @description RoleServiceFacadeImpl:
 * @create 2017 04 12 16:56.
 */
@Facade
public class RoleServiceFacadeImpl implements RoleServiceFacade {
    @Override
    public void addRole(CreateRoleCommand command) {
        ParamsValidatorUtil.validate(command);
        roleService.addRole(command.getRoleName(), command.getDescription());
    }

    @Override
    public void addRoleWithPerms(CreateRoleWithPermCommand command) {
        ParamsValidatorUtil.validate(command);
        roleService.addRoleWithPerms(command.getRoleName(), command.getDescription(),
                BeanMapper.mapList(command.getResources(), Resource.class));
    }

    @Override
    public List<RoleDTO> getAllRoleWithPerms() {
        List<Role> roles = roleService.getAllRoleWithPerms();
        return RoleDTOAssembler.toDTO(roles);
    }

    @Override
    public List<RoleDTO> getAllRole() {
        List<Role> roles = roleService.getAllRole();
        return RoleDTOAssembler.toDTO(roles);
    }

    @Override
    public PageList findRolesWithPerms(String roleName, int pageIndex, int pageSize) {
        Role where = new Role().setRoleName(roleName);
        Page page = new Page(pageIndex, pageSize);
        Criteria<Role> criteria = new Criteria<>(where, page);
        List<Role> roles = roleService.findRolesWithPerms(criteria);

        int size = roleService.getRolesSize(criteria);

        return new PageList(size, RoleDTOAssembler.toDTO(roles));
    }

    @Override
    public void updateRole(UpdateRoleCommand command) {
        ParamsValidatorUtil.validate(command);
        roleService.updateRole(command.getRoleId(), command.getRoleName(), command.getRoleDesc(),
                BeanMapper.mapList(command.getResources(), Resource.class));
    }

    @Override
    public void deleteRole(DeleteRoleCommand command) {
        ParamsValidatorUtil.validate(command);
        roleService.deleteRole(command.getRoleId());
    }

    @Autowired
    private RoleService roleService;
}

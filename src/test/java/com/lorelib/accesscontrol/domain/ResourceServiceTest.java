package com.lorelib.accesscontrol.domain;

import com.lorelib.accesscontrol.common.ResourceType;
import com.lorelib.accesscontrol.commons.TestNGUtil;
import com.lorelib.accesscontrol.commons.algorithm.IdGenerator;
import com.lorelib.accesscontrol.domain.access.Operation;
import com.lorelib.accesscontrol.domain.access.Resource;
import com.lorelib.accesscontrol.domain.access.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源服务
 * Created by listening on 2017/3/21.
 */
public class ResourceServiceTest extends TestNGUtil {
    @Autowired
    private ResourceService resourceService;

    @Test
    public void addResource() {
        Resource resource = new Resource(ResourceType.API.name(), "user", "/user");
        resource.outResourceId(IdGenerator.nextId());
        List<Operation> opts = new ArrayList<>();
        opts.add(new Operation(resource.id(), "新增用户", "/addUser"));

        if (validate(resource)) resourceService.addResource(resource);
    }

    @Test
    public void deleteResource() {
        resourceService.deleteResource(845192683969449984L);
    }
}

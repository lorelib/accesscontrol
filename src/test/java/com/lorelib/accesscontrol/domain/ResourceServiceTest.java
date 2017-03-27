package com.lorelib.accesscontrol.domain;

import com.lorelib.accesscontrol.common.ResourceType;
import com.lorelib.accesscontrol.infrastructure.test.TestNGUtil;
import com.lorelib.accesscontrol.infrastructure.helpers.algorithm.IdGenerator;
import com.lorelib.accesscontrol.infrastructure.helpers.utils.JSONUtil;
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
    public void addResourceTest() {
        Resource resource = new Resource(ResourceType.API.name(), "user", "/user");
        List<Operation> opts = new ArrayList<>();
        opts.add(new Operation(resource.getId(), "新增用户", "/addUser"));
        resource.outResourceId(IdGenerator.nextId()).opts(opts);

        if (validate(resource)) resourceService.addResource(resource);
    }

    @Test
    public void deleteResourceTest() {
        List<Resource> resources = resourceService.getResourcesByType(ResourceType.API.name());
        for (Resource resource: resources) {
            resourceService.deleteResource(resource.getId());
        }
    }

    @Test
    public void getResourcesByTypeTest() {
        List<Resource> resources = resourceService.getResourcesByType(ResourceType.API.name());
        System.out.println(JSONUtil.toJsonString(resources));
    }
}

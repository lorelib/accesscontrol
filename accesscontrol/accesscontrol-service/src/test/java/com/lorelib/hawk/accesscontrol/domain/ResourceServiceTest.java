package com.lorelib.hawk.accesscontrol.domain;

import com.lorelib.hawk.accesscontrol.common.ResourceType;
import com.lorelib.hawk.accesscontrol.domain.access.Operation;
import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import com.lorelib.hawk.accesscontrol.domain.access.Resource;
import com.lorelib.hawk.accesscontrol.domain.access.ResourceService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
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
        Resource resource = new Resource(ResourceType.API.name(), "file", "/file");
        List<Operation> opts = new ArrayList<>();
        opts.add(new Operation(resource.getId(), "新增文件", "/addFile"));
        resource.opts(opts);

        if (validate(resource)) resourceService.addResource(resource);
    }

    @Test
    public void getResourcesByType() {
        List<Resource> resources = resourceService.getResourcesByType(ResourceType.API.name());
        System.out.println(new ReflectionToStringBuilder(resources.toArray()).toString());
    }
}

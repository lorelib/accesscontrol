package com.lorelib.hawk.accesscontrol.domain;

import com.lorelib.hawk.accesscontrol.common.ResourceType;
import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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
        Resource resource = new Resource(ResourceType.API.name(), "file3", "/file3");
        List<Resource> sub = new ArrayList<>();
        sub.add(new Resource(resource.getId(), resource.resourceType(), "新增文件", "/addFile"));
        resource.addSubResources(sub);

        System.out.println(ReflectionToStringBuilder.toString(resource, ToStringStyle.JSON_STYLE));
        if (validate(resource)) resourceService.addResource(resource);
    }

    @Test
    public void getResourcesByType() {
        List<Resource> resources = resourceService.getResourcesByType(ResourceType.API.name());
        System.out.println(new ReflectionToStringBuilder(resources.toArray()).toString());
    }
}

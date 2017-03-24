package com.lorelib.accesscontrol.domain;

import com.lorelib.accesscontrol.common.ResourceType;
import com.lorelib.accesscontrol.commons.TestNGUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 资源服务
 * Created by listening on 2017/3/21.
 */
public class ResourceServiceTest extends TestNGUtil {
    @Autowired
    private ResourceService resourceService;

    @Test
    public void addResource() {
        Resource resource = new Resource(1, ResourceType.API.name(), "user", "/user");
        Set<Operation> opts = new HashSet<>();
        opts.add(new Operation(resource.outResourceId(), "新增用户", "/addUser"));
        resource.companyInfo(new CompanyInfo(1003038, 13)).opts(opts);

        if (validate(resource)) resourceService.addResource(resource);
    }
}

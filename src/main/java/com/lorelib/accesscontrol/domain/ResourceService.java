package com.lorelib.accesscontrol.domain;

import com.lorelib.accesscontrol.commons.stereotype.DomainService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 资源服务
 * Created by listening on 2017/3/21.
 */
@DomainService
public class ResourceService {
    /**
     * 添加资源
     *
     * @param resource
     */
    public void addResource(Resource resource) {
        resourceRepository.addResource(resource);
    }

    /**
     * 删除资源
     *
     * @param resource
     */
    public void deleteResource(Resource resource) {
        resourceRepository.deleteResource(resource);
    }

    /**
     * 更新资源
     *
     * @param resource
     */
    public void updateResource(Resource resource) {
        resourceRepository.updateResource(resource);
    }

    /**
     * 根据产品code与组织机构ID获取资源信息
     *
     * @param productCode
     * @param organizationId
     * @return
     */
    public Set<Resource> getResourcesBy(int productCode, int organizationId) {
        return resourceRepository.getResourcesBy(productCode, organizationId);
    }

    @Autowired
    private ResourceRepository resourceRepository;
}

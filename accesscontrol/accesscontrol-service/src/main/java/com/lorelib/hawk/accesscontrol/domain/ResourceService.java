package com.lorelib.hawk.accesscontrol.domain;

import com.lorelib.hawk.infrastructure.stereotype.DomainService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
     * @param resourceId
     */
    public void deleteResource(long resourceId) {
        resourceRepository.deleteResource(resourceId);
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
     * 通过资源类型获取资源
     *
     * @return
     */
    public List<Resource> getResourcesByType(String resourceType) {
        return resourceRepository.getResourcesByType(resourceType);
    }

    @Autowired
    private ResourceRepository resourceRepository;
}

package com.lorelib.hawk.accesscontrol.infrastructure.persistence;

import com.lorelib.hawk.accesscontrol.domain.access.Operation;
import com.lorelib.hawk.infrastructure.stereotype.Repository;
import com.lorelib.hawk.accesscontrol.domain.access.Resource;
import com.lorelib.hawk.accesscontrol.domain.access.ResourceRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by listening on 2017/3/21.
 */
@Repository
public class ResourceRepositoryImpl implements ResourceRepository {
    @Override
    public void addResource(Resource resource) {
        sqlSession.insert(RESOURCE_MAPPER + "addResource", resource);
    }

    @Override
    public void deleteResource(long resourceId) {
        sqlSession.delete(RESOURCE_MAPPER + "deleteResource", resourceId);
    }

    @Override
    public void updateResource(Resource resource) {
        sqlSession.update(RESOURCE_MAPPER + "updateResource", resource);
        if (CollectionUtils.isNotEmpty(resource.opts())) {
            sqlSession.update(RESOURCE_MAPPER + "updateOptsByResourceId", resource.opts());
        }
    }

    @Override
    public List<Resource> getResourcesByType(String resourceType) {
        List<Resource> resources = sqlSession.selectList(RESOURCE_MAPPER + "getResourcesByType", resourceType);
        for (Resource resource: resources) {
            List<Operation> opts = sqlSession.selectList(RESOURCE_MAPPER + "getOptsByResourceId", resource.getId());
            resource.opts(opts);
        }
        return resources;
    }

    @Autowired
    private SqlSessionTemplate sqlSession;
    private final static String RESOURCE_MAPPER = "com.lorelib.hawk.accesscontrol.domain.access.ResourceRepository.";
}

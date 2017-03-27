package com.lorelib.accesscontrol.infrastructure.persistence;

import com.lorelib.accesscontrol.infrastructure.stereotype.Repository;
import com.lorelib.accesscontrol.domain.access.Operation;
import com.lorelib.accesscontrol.domain.access.Resource;
import com.lorelib.accesscontrol.domain.access.ResourceRepository;
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
        if (CollectionUtils.isNotEmpty(resource.getOpts())) {
            sqlSession.update(RESOURCE_MAPPER + "updateOptsByResourceId", resource.getOpts());
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
    private final static String RESOURCE_MAPPER = "com.lorelib.accesscontrol.domain.access.ResourceRepository.";
}

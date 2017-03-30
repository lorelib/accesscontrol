package com.lorelib.hawk.accesscontrol.infrastructure.persistence;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.lorelib.hawk.infrastructure.stereotype.Repository;
import com.lorelib.hawk.accesscontrol.domain.access.Resource;
import com.lorelib.hawk.accesscontrol.domain.access.ResourceRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by listening on 2017/3/21.
 */
@Repository
public class ResourceRepositoryImpl implements ResourceRepository {
    @Override
    public void addResource(Resource resource) {
        // 检查是否包含子资源，包含则将其放入需要新增的列表
        if (CollectionUtils.isEmpty(resource.subResources())) {
            sqlSession.insert(RESOURCE_MAPPER + "addResource", resource);
        } else {
            addBatchResources(Lists.newArrayList(resource));
        }
    }

    @Override
    public void addBatchResources(List<Resource> resources) {
        List<Resource> list = Lists.newArrayList();
        for (Resource resource: resources) {
            list.add(resource.withoutSubResources());
            // 检查是否包含子资源，包含则将其放入需要新增的列表
            if (CollectionUtils.isNotEmpty(resource.subResources())) {
                Iterators.addAll(list, resource.subResources().iterator());
            }
        }
        sqlSession.insert(RESOURCE_MAPPER + "addBatchResources", list);
    }

    @Override
    public void deleteResource(long resourceId) {
        sqlSession.delete(RESOURCE_MAPPER + "deleteResource", resourceId);
    }

    @Override
    public void updateResource(Resource resource) {

    }

    @Override
    public List<Resource> getResourcesByType(String resourceType) {
        List<Resource> resources = sqlSession.selectList(RESOURCE_MAPPER + "getResourcesByType", resourceType);

        return resources;
    }

    @Autowired
    private SqlSessionTemplate sqlSession;
    private final static String RESOURCE_MAPPER = "com.lorelib.hawk.accesscontrol.domain.access.ResourceRepository.";
}

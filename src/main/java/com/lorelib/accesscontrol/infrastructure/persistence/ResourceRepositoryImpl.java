package com.lorelib.accesscontrol.infrastructure.persistence;

import com.lorelib.accesscontrol.domain.Resource;
import com.lorelib.accesscontrol.domain.ResourceRepository;
import com.lorelib.accesscontrol.commons.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by listening on 2017/3/21.
 */
@Repository
public class ResourceRepositoryImpl implements ResourceRepository {
    /**
     * 添加资源
     *
     * @param resource
     */
    public void addResource(Resource resource) {
        sqlSession.insert(RESOURCE_MAPPER + "addResource", resource);
    }

    /**
     * 删除资源
     *
     * @param resource
     */
    public void deleteResource(Resource resource) {

    }

    /**
     * 更新资源
     *
     * @param resource
     */
    public void updateResource(Resource resource) {

    }

    /**
     * 根据产品code与组织机构ID获取资源信息
     *
     * @param productCode
     * @param organizationId
     * @return
     */
    public Set<Resource> getResourcesBy(int productCode, int organizationId) {

        return null;
    }

    @Autowired
    private SqlSession sqlSession;
    private final static String RESOURCE_MAPPER = "com.lorelib.accesscontrol.domain.ResourceRepositoryImpl.";
}

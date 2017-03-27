package com.lorelib.accesscontrol.infrastructure.persistence;

import com.lorelib.accesscontrol.domain.access.Resource;
import com.lorelib.accesscontrol.domain.access.ResourceRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by listening on 2017/3/21.
 */
public interface ResourceRepositoryImpl extends ResourceRepository {
    void addResource(Resource resource);

    void deleteResource(long resourceId);

    void updateResource(Resource resource);

    List<Resource> getResourcesBy(@Param("productCode") int productCode, @Param("organizationId") int organizationId);
}

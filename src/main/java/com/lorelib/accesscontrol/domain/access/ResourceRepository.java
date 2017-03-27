package com.lorelib.accesscontrol.domain.access;

import com.lorelib.accesscontrol.commons.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资源仓库
 * Created by listening on 2017/3/21.
 */
@Repository
public interface ResourceRepository {
    /**
     * 添加资源
     *
     * @param resource
     */
    void addResource(Resource resource);

    /**
     * 删除资源
     *
     * @param resourceId
     */
    void deleteResource(long resourceId);

    /**
     * 更新资源
     *
     * @param resource
     */
    void updateResource(Resource resource);

    /**
     * 根据产品code与组织机构ID获取资源信息
     *
     * @param productCode
     * @param organizationId
     * @return
     */
    List<Resource> getResourcesBy(@Param("productCode") int productCode, @Param("organizationId") int organizationId);
}

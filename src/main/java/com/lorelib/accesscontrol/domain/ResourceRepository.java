package com.lorelib.accesscontrol.domain;

import java.util.Set;

/**
 * Created by listening on 2017/3/21.
 */
public interface ResourceRepository  {
    /**
     * 添加资源
     * @param resource
     */
    void addResource(Resource resource);

    /**
     * 删除资源
     * @param resource
     */
    void deleteResource(Resource resource);

    /**
     * 更新资源
     * @param resource
     */
    void updateResource(Resource resource);

    /**
     * 根据产品code与组织机构ID获取资源信息
     * @param productCode
     * @param organizationId
     * @return
     */
    Set<Resource> getResourcesBy(int productCode, int organizationId);
}

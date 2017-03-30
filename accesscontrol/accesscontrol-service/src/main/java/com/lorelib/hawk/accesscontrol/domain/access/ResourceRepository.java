package com.lorelib.hawk.accesscontrol.domain.access;

import java.util.List;

/**
 * 资源仓库
 * Created by listening on 2017/3/21.
 */
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
     * 通过资源类型获取资源
     *
     * @return
     */
    List<Resource> getResourcesByType(String resourceType);
}

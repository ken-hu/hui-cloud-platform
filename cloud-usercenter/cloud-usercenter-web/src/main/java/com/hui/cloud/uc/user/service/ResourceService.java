package com.hui.cloud.uc.user.service;

import com.hui.cloud.uc.user.model.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-18
 */
public interface ResourceService extends IService<Resource> {

    /**
     * 删除资源
     * @param resourceId
     * @return
     */
    int deleteById(String resourceId);

    /**
     * 新增资源
     * @param resource
     * @return
     */
    Resource addResource(Resource resource);

    /**
     * 更新资源
     * @param resource
     * @return
     */
    int updateResource(Resource resource);
}

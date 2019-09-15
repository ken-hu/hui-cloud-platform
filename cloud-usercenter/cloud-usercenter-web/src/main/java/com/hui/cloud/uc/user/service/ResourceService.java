package com.hui.cloud.uc.user.service;

import com.hui.cloud.uc.user.model.entity.Resource;

import java.util.List;

/**
 * <b><code>ResourceService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/15 17:04.
 *
 * @author Hu-Weihui
 */
public interface ResourceService {

    /**
     * 查询用户的资源
     * @param userId
     * @return
     */
    List<Resource> listByUserId(Long userId);


    /**
     * 通过类型查询资源
     * @param resourceType
     * @return
     */
    List<Resource> listByType(String resourceType);
}

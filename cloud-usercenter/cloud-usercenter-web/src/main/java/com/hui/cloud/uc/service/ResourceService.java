package com.hui.cloud.uc.service;

import com.hui.cloud.uc.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
public interface ResourceService extends IService<Resource> {
    /**
     * 分页查询资源
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Resource> listByPage(Integer pageNum, Integer pageSize);

    /**
     * 查询权限的资源
     * @param permissionId
     * @return
     */
    HashSet<Resource> listByPermissionId(Long permissionId);
}

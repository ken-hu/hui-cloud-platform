package com.hui.cloud.uc.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.cloud.uc.user.model.entity.SysResource;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
public interface SysResourceService extends IService<SysResource> {

    /**
     * 分页查询资源
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<SysResource> listByPage(Integer pageNum,Integer pageSize);

    /**
     * 查询权限的资源
     * @param permissionId
     * @return
     */
    HashSet<SysResource> listByPermissionId(Long permissionId);

}

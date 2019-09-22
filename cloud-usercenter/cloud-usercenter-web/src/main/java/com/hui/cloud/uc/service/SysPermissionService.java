package com.hui.cloud.uc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.cloud.uc.entity.SysPermission;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-20
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 分页查询权限
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<SysPermission> listByPage(Integer pageNum, Integer pageSize);

    /**
     * 查询用户的权限
     * @param userId
     * @return
     */
    HashSet<SysPermission> listByUserId(Long userId);

    /**
     * 查询角色的所有权限
     * @param roleId
     * @return
     */
    HashSet<SysPermission> listByRoleId(Long roleId);

    /**
     * 权限绑定资源
     * @param resourceIds
     * @param permissionId
     */
    void bindResource(List<Long> resourceIds, Long permissionId);
}

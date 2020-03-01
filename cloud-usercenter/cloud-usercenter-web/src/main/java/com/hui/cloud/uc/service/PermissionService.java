package com.hui.cloud.uc.service;

import com.hui.cloud.uc.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
public interface PermissionService extends IService<Permission> {

    /**
     * 分页查询权限
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Permission> listByPage(Integer pageNum, Integer pageSize);

    /**
     * 查询用户的权限
     * @param userId
     * @return
     */
    HashSet<Permission> listByUserId(Long userId);

    /**
     * 查询角色的所有权限
     * @param roleId
     * @return
     */
    HashSet<Permission> listByRoleId(Long roleId);

    /**
     * 权限绑定资源
     * @param resourceIds
     * @param permissionId
     */
    void bindResource(List<Long> resourceIds, Long permissionId);
}

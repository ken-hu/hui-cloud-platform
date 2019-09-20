package com.hui.cloud.uc.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.cloud.uc.user.model.entity.SysPermission;

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
    List<SysPermission> listByUserId(Long userId);

    /**
     * 查询角色的所有权限
     * @param roleId
     * @return
     */
    List<SysPermission> listByRoleId(Long roleId);
}

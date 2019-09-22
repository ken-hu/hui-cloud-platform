package com.hui.cloud.uc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.cloud.uc.entity.SysRole;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 分页查询角色
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<SysRole> listByPage(Integer pageNum, Integer pageSize);

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    HashSet<SysRole> listByUserId(Long userId);

    /**
     * 查询组角色
     *
     * @param groupId
     * @return
     */
    HashSet<SysRole> listByGroupId(Long groupId);

    /**
     *  角色绑定权限
     * @param permissionIds
     * @param roleId
     */
    void bindPermissions(List<Long> permissionIds, Long roleId);
}

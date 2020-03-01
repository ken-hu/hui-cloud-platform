package com.hui.cloud.uc.service;

import com.hui.cloud.uc.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
public interface RoleService extends IService<Role> {

    /**
     * 分页查询角色
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Role> listByPage(Integer pageNum, Integer pageSize);

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    HashSet<Role> listByUserId(Long userId);

    /**
     * 查询组角色
     *
     * @param groupId
     * @return
     */
    HashSet<Role> listByGroupId(Long groupId);

    /**
     *  角色绑定权限
     * @param permissionIds
     * @param roleId
     */
    void bindPermissions(List<Long> permissionIds, Long roleId);
}

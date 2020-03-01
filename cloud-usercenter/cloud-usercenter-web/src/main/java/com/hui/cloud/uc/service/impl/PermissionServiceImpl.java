package com.hui.cloud.uc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.cloud.uc.entity.Permission;
import com.hui.cloud.uc.entity.Role;
import com.hui.cloud.uc.mapper.PermissionMapper;
import com.hui.cloud.uc.service.PermissionService;
import com.hui.cloud.uc.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    private PermissionMapper PermissionMapper;

    private RoleService roleService;

    public PermissionServiceImpl(com.hui.cloud.uc.mapper.PermissionMapper permissionMapper, RoleService roleService) {
        PermissionMapper = permissionMapper;
        this.roleService = roleService;
    }

    /**
     * 分页查询权限
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Permission> listByPage(Integer pageNum, Integer pageSize) {
        QueryWrapper<Permission> query = Wrappers.query();
        Page<Permission> page = new Page<>(pageNum, pageSize);
        List<Permission> Permissions = PermissionMapper.selectPage(page, query).getRecords();
        return Permissions;
    }

    /**
     * 查询用户权限
     *
     * @param userId
     * @return
     */
    @Override
    public HashSet<Permission> listByUserId(Long userId) {
        HashSet<Role> sysRoles = roleService.listByUserId(userId);
        HashSet<Permission> Permissions = new HashSet<>();
        sysRoles.forEach(x -> {
            HashSet<Permission> permissions = listByRoleId(x.getRoleId());
            Permissions.addAll(permissions);
        });
        return Permissions;
    }

    /**
     * 查询角色的所有权限
     *
     * @param roleId
     * @return
     */
    @Override
    public HashSet<Permission> listByRoleId(Long roleId) {
        HashSet<Permission> Permissions = PermissionMapper.selectByRoleId(roleId);
        return Permissions;
    }

    /**
     * 权限绑定资源
     *
     * @param resourceIds
     * @param permissionId
     */
    @Override
    public void bindResource(List<Long> resourceIds, Long permissionId) {
        resourceIds.forEach(x -> PermissionMapper.insertResourcePermissionRel(permissionId,x));
    }
}

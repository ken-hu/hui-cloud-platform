package com.hui.cloud.uc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.cloud.uc.entity.SysPermission;
import com.hui.cloud.uc.entity.SysRole;
import com.hui.cloud.uc.mapper.SysPermissionMapper;
import com.hui.cloud.uc.service.SysPermissionService;
import com.hui.cloud.uc.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-20
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    private SysPermissionMapper sysPermissionMapper;

    private SysRoleService sysRoleService;

    @Autowired
    public SysPermissionServiceImpl(SysPermissionMapper sysPermissionMapper, SysRoleService sysRoleService) {
        this.sysPermissionMapper = sysPermissionMapper;
        this.sysRoleService = sysRoleService;
    }

    /**
     * 分页查询权限
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<SysPermission> listByPage(Integer pageNum, Integer pageSize) {
        QueryWrapper<SysPermission> query = Wrappers.query();
        Page<SysPermission> page = new Page<>(pageNum, pageSize);
        List<SysPermission> sysPermissions = sysPermissionMapper.selectPage(page, query).getRecords();
        return sysPermissions;
    }

    /**
     * 查询用户权限
     *
     * @param userId
     * @return
     */
    @Override
    public HashSet<SysPermission> listByUserId(Long userId) {
        HashSet<SysRole> sysRoles = sysRoleService.listByUserId(userId);
        HashSet<SysPermission> sysPermissions = new HashSet<>();
        sysRoles.forEach(x -> {
            HashSet<SysPermission> permissions = listByRoleId(x.getRoleId());
            sysPermissions.addAll(permissions);
        });
        return sysPermissions;
    }

    /**
     * 查询角色的所有权限
     *
     * @param roleId
     * @return
     */
    @Override
    public HashSet<SysPermission> listByRoleId(Long roleId) {
        HashSet<SysPermission> sysPermissions = sysPermissionMapper.selectByRoleId(roleId);
        return sysPermissions;
    }

    /**
     * 权限绑定资源
     *
     * @param resourceIds
     * @param permissionId
     */
    @Override
    public void bindResource(List<Long> resourceIds, Long permissionId) {
        resourceIds.forEach(x -> sysPermissionMapper.insertResourcePermissionRel(permissionId,x));
    }
}

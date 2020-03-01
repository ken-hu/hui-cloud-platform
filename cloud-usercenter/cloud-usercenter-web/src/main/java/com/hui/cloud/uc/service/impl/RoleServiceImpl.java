package com.hui.cloud.uc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.cloud.uc.entity.Role;
import com.hui.cloud.uc.mapper.RoleMapper;
import com.hui.cloud.uc.service.GroupService;
import com.hui.cloud.uc.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    private RoleMapper roleMapper;
    private GroupService groupService;


    /**
     * 分页查询角色
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Role> listByPage(Integer pageNum, Integer pageSize) {
        QueryWrapper<Role> query = Wrappers.<Role>query();
        Page<Role> page = new Page<>(pageNum, pageSize);
        List<Role> Roles = roleMapper.selectPage(page, query).getRecords();
        return Roles;
    }

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    @Override
    public HashSet<Role> listByUserId(Long userId) {
        HashSet<Role> Roles = roleMapper.selectByUserId(userId);
        HashSet<Role> sysGroupRoles = listByGroupId(userId);
        Roles.addAll(sysGroupRoles);
        return Roles;
    }

    /**
     * 查询组角色
     *
     * @param groupId
     * @return
     */
    @Override
    public HashSet<Role> listByGroupId(Long groupId) {
        HashSet<Role> Roles = roleMapper.selectByGroupId(groupId);
        return Roles;
    }

    /**
     * 用户绑定权限
     *
     * @param permissionIds
     * @param roleId
     */
    @Override
    public void bindPermissions(List<Long> permissionIds, Long roleId) {
        permissionIds.forEach(x -> roleMapper.insertRolePermissionRel(roleId, x));
    }

}

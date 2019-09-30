package com.hui.cloud.uc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.cloud.uc.mapper.SysRoleMapper;
import com.hui.cloud.uc.entity.SysRole;
import com.hui.cloud.uc.service.SysGroupService;
import com.hui.cloud.uc.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    private SysRoleMapper sysRoleMapper;
    private SysGroupService sysGroupService;

    @Autowired
    public SysRoleServiceImpl(SysRoleMapper sysRoleMapper, SysGroupService sysGroupService) {
        this.sysRoleMapper = sysRoleMapper;
        this.sysGroupService = sysGroupService;
    }

    /**
     * 分页查询角色
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<SysRole> listByPage(Integer pageNum, Integer pageSize) {
        QueryWrapper<SysRole> query = Wrappers.<SysRole>query();
        Page<SysRole> page = new Page<>(pageNum, pageSize);
        List<SysRole> sysRoles = sysRoleMapper.selectPage(page, query).getRecords();
        return sysRoles;
    }

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    @Override
    public HashSet<SysRole> listByUserId(Long userId) {
        HashSet<SysRole> sysRoles = sysRoleMapper.selectByUserId(userId);
        HashSet<SysRole> sysGroupRoles = listByGroupId(userId);
        sysRoles.addAll(sysGroupRoles);
        return sysRoles;
    }

    /**
     * 查询组角色
     *
     * @param groupId
     * @return
     */
    @Override
    public HashSet<SysRole> listByGroupId(Long groupId) {
        HashSet<SysRole> sysRoles = sysRoleMapper.selectByGroupId(groupId);
        return sysRoles;
    }

    /**
     * 用户绑定权限
     *
     * @param permissionIds
     * @param roleId
     */
    @Override
    public void bindPermissions(List<Long> permissionIds, Long roleId) {
        permissionIds.forEach(x -> sysRoleMapper.insertRolePermissionRel(roleId, x));
    }

}

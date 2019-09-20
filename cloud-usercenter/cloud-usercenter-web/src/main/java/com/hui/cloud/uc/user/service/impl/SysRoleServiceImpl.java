package com.hui.cloud.uc.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.cloud.uc.user.mapper.SysRoleMapper;
import com.hui.cloud.uc.user.model.entity.SysRole;
import com.hui.cloud.uc.user.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    public SysRoleServiceImpl(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    /**
     * 分页查询角色
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<SysRole> listByPage(Integer pageNum,Integer pageSize) {
        Page<SysRole> page = new Page<>(pageNum, pageSize);
        List<SysRole> sysRoles = sysRoleMapper.selectPage(page, null).getRecords();
        return sysRoles;
    }
}

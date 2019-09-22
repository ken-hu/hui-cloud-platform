package com.hui.cloud.uc.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.cloud.uc.user.mapper.SysResourceMapper;
import com.hui.cloud.uc.user.model.entity.SysResource;
import com.hui.cloud.uc.user.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceService {

    private SysResourceMapper sysResourceMapper;

    @Autowired
    public SysResourceServiceImpl(SysResourceMapper sysResourceMapper) {
        this.sysResourceMapper = sysResourceMapper;
    }

    /**
     * 分页查询资源
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<SysResource> listByPage(Integer pageNum, Integer pageSize) {
        QueryWrapper<SysResource> query = Wrappers.<SysResource>query();
        Page<SysResource> page = new Page<>(pageNum, pageSize);
        List<SysResource> sysResources = sysResourceMapper.selectPage(page, query).getRecords();
        return sysResources;
    }

    /**
     * 查询权限的资源
     *
     * @param permissionId
     * @return
     */
    @Override
    public HashSet<SysResource> listByPermissionId(Long permissionId) {
        HashSet<SysResource> sysResources = sysResourceMapper.listByPermissionId(permissionId);
        return sysResources;
    }
}

package com.hui.cloud.uc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.cloud.uc.entity.Resource;
import com.hui.cloud.uc.mapper.ResourceMapper;
import com.hui.cloud.uc.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2020-02-23
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {
    private ResourceMapper resourceMapper;

    @Autowired
    public ResourceServiceImpl(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }

    /**
     * 分页查询资源
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Resource> listByPage(Integer pageNum, Integer pageSize) {
        QueryWrapper<Resource> query = Wrappers.<Resource>query();
        Page<Resource> page = new Page<>(pageNum, pageSize);
        List<Resource> sysResources = resourceMapper.selectPage(page, query).getRecords();
        return sysResources;
    }

    /**
     * 查询权限的资源
     *
     * @param permissionId
     * @return
     */
    @Override
    public HashSet<Resource> listByPermissionId(Long permissionId) {
        return resourceMapper.listByPermissionId(permissionId);
    }
}

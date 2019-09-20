package com.hui.cloud.uc.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.cloud.uc.user.mapper.SysPermissionMapper;
import com.hui.cloud.uc.user.model.entity.SysPermission;
import com.hui.cloud.uc.user.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    public SysPermissionServiceImpl(SysPermissionMapper sysPermissionMapper) {
        this.sysPermissionMapper = sysPermissionMapper;
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
        Page<SysPermission> page = new Page<>(pageNum, pageSize);
        List<SysPermission> sysPermissions = sysPermissionMapper.selectPage(page, null).getRecords();
        return sysPermissions;
    }
}

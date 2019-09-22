package com.hui.cloud.uc.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.cloud.uc.user.mapper.SysGroupMapper;
import com.hui.cloud.uc.user.model.entity.SysGroup;
import com.hui.cloud.uc.user.service.SysGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 组表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-20
 */
@Service
public class SysGroupServiceImpl extends ServiceImpl<SysGroupMapper, SysGroup> implements SysGroupService {

    private SysGroupMapper sysGroupMapper;

    @Autowired
    public SysGroupServiceImpl(SysGroupMapper sysGroupMapper) {
        this.sysGroupMapper = sysGroupMapper;
    }

    /**
     * 分页查询用户组
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<SysGroup> listByPage(Integer pageNum, Integer pageSize) {
        Page<SysGroup> page = new Page<>(pageNum, pageSize);
        List<SysGroup> sysGroups = sysGroupMapper.selectPage(page, null).getRecords();
        return sysGroups;
    }

    /**
     * 查询用户所属用户组
     *
     * @param userId
     * @return
     */
    @Override
    public HashSet<SysGroup> listByUserId(Long userId) {
        HashSet<SysGroup> sysGroups = sysGroupMapper.listByUserId(userId);
        return sysGroups;
    }
}

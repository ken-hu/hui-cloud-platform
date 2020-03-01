package com.hui.cloud.uc.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.cloud.uc.entity.Group;
import com.hui.cloud.uc.mapper.GroupMapper;
import com.hui.cloud.uc.service.GroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2020-02-23
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {
    private GroupMapper groupMapper;

    @Autowired
    public GroupServiceImpl(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }


    /**
     * 分页查询用户组
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Group> listByPage(Integer pageNum, Integer pageSize) {
        Page<Group> page = new Page<>(pageNum, pageSize);
        List<Group> sysGroups = groupMapper.selectPage(page, null).getRecords();
        return sysGroups;
    }

    /**
     * 查询用户所属用户组
     *
     * @param userId
     * @return
     */
    @Override
    public HashSet<Group> listByUserId(Long userId) {
        return groupMapper.listByUserId(userId);
    }
}

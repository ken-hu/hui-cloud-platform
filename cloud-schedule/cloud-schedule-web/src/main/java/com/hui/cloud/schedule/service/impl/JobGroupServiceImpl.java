package com.hui.cloud.schedule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.cloud.schedule.entity.JobGroup;
import com.hui.cloud.schedule.mapper.JobGroupMapper;
import com.hui.cloud.schedule.service.JobGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * JOB组 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-11-16
 */
@Service
public class JobGroupServiceImpl extends ServiceImpl<JobGroupMapper, JobGroup> implements JobGroupService {

    private JobGroupMapper jobGroupMapper;

    @Autowired
    public JobGroupServiceImpl(JobGroupMapper jobGroupMapper) {
        this.jobGroupMapper = jobGroupMapper;
    }

    @Override
    public List<JobGroup> listByPage(Integer pageNum,Integer pageSize) {
        QueryWrapper<JobGroup> queryWrapper = new QueryWrapper<JobGroup>();
        Page<JobGroup> page = new Page<>(pageNum, pageSize);
        List<JobGroup> jobGroups = jobGroupMapper.selectPage(page, queryWrapper).getRecords();
        return jobGroups;
    }
}

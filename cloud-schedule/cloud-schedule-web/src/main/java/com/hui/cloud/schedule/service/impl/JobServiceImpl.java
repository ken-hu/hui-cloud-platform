package com.hui.cloud.schedule.service.impl;

import com.hui.cloud.schedule.entity.Job;
import com.hui.cloud.schedule.mapper.JobMapper;
import com.hui.cloud.schedule.service.JobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 调度JOB 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-11-16
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {

}

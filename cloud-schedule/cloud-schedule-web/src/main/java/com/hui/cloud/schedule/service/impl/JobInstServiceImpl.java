package com.hui.cloud.schedule.service.impl;

import com.hui.cloud.schedule.entity.JobInst;
import com.hui.cloud.schedule.mapper.JobInstMapper;
import com.hui.cloud.schedule.service.JobInstService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 调度JOB实例 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-11-09
 */
@Service
public class JobInstServiceImpl extends ServiceImpl<JobInstMapper, JobInst> implements JobInstService {

}

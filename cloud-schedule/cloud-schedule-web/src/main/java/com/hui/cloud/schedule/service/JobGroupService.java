package com.hui.cloud.schedule.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.cloud.schedule.entity.JobGroup;

import java.util.List;

/**
 * <p>
 * JOB组 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-11-16
 */
public interface JobGroupService extends IService<JobGroup> {

    List<JobGroup> listByPage(Integer pageNum,Integer pageSize);
}

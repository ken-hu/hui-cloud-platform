package com.hui.cloud.schedule.service.impl;

import com.hui.cloud.schedule.service.ScheduleService;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <code>ScheduleServiceImpl</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/6 15:25.
 *
 * @author Gary.Hu
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    private Scheduler scheduler;

    @Autowired
    public ScheduleServiceImpl(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void delJob() {
    }

    @Override
    public void newJob() {
    }

    @Override
    public void pauseJob() {

    }

    @Override
    public void updateJob() {

    }

    @Override
    public void cancleJob() {

    }
}

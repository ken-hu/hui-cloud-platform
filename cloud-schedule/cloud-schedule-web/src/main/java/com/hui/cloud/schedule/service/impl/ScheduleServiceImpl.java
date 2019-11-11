package com.hui.cloud.schedule.service.impl;

import com.hui.cloud.schedule.job.CommonJob;
import com.hui.cloud.schedule.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
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
@Slf4j
public class ScheduleServiceImpl implements ScheduleService {
    private Scheduler scheduler;

    @Autowired
    public ScheduleServiceImpl(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void starJob() {
        try {
            scheduler.resumeJob(JobKey.jobKey("e65e2a67-3b26-4954-a3d5-1a126fedd6b2", "com.hui.cloud.schedule.job.CommonJob"));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delJob() {
    }

    @Override
    public void newJob(String jobName, String jobGroup, String cronExpress) {
//        String jobName = UUID.randomUUID().toString();

        String group = CommonJob.class.getName();

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1  * * * * ?");

        JobDetail jobDetail = JobBuilder.newJob(CommonJob.class)
                .withIdentity(jobName, group)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(jobName, group)
                .withSchedule(cronScheduleBuilder)
                .build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            log.error(" schedule exception ", e);
        }
    }

    @Override
    public void pauseJob() {
        JobKey jobKey = JobKey.jobKey("e65e2a67-3b26-4954-a3d5-1a126fedd6b2","com.hui.cloud.schedule.job.CommonJob");
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            log.error(" schedule exception ", e);
        }
    }

    @Override
    public void updateJob() {

    }

}

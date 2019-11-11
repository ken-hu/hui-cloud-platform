package com.hui.cloud.schedule.service;

/**
 * <code>ScheduleService</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/6 15:25.
 *
 * @author Gary.Hu
 */
public interface ScheduleService {

    void starJob();

    void delJob();

    void newJob(String jobName, String jobGroup, String cronExpress);

    void pauseJob();

    void updateJob();

}

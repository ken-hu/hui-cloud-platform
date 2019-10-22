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
    void delJob();

    void newJob();

    void pauseJob();

    void updateJob();

    void cancleJob();
}

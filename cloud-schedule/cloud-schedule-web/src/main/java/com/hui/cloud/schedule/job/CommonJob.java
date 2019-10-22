package com.hui.cloud.schedule.job;

import org.quartz.*;

/**
 * <code>CommonJob</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/20 11:45.
 *
 * @author Gary.Hu
 */
public class CommonJob implements JobDetail {
    @Override
    public JobKey getKey() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Class<? extends Job> getJobClass() {
        return null;
    }

    @Override
    public JobDataMap getJobDataMap() {
        return null;
    }

    @Override
    public boolean isDurable() {
        return false;
    }

    @Override
    public boolean isPersistJobDataAfterExecution() {
        return false;
    }

    @Override
    public boolean isConcurrentExectionDisallowed() {
        return false;
    }

    @Override
    public boolean requestsRecovery() {
        return false;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public JobBuilder getJobBuilder() {
        return null;
    }
}

package com.hui.cloud.schedule.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * <code>CommonJob</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/20 11:45.
 *
 * @author Gary.Hu
 */
@DisallowConcurrentExecution
@Slf4j
public class CommonJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("CommonJob excuting .........");
    }
}

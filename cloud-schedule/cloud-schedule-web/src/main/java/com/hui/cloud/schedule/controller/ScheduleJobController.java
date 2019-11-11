package com.hui.cloud.schedule.controller;

import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.schedule.entity.JobInst;
import com.hui.cloud.schedule.service.JobInstService;
import com.hui.cloud.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <code>ScheduleController</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/6 15:58.
 *
 * @author Gary.Hu
 */
@RestController
public class ScheduleJobController {

    private ScheduleService scheduleService;

    private JobInstService jobInstService;

    @Autowired
    public ScheduleJobController(ScheduleService scheduleService, JobInstService jobInstService) {
        this.scheduleService = scheduleService;
        this.jobInstService = jobInstService;
    }

    /**
     * 分页查询JOB实例
     *
     * @return
     */
    @GetMapping(value = "/jobs", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listJobs(@RequestParam Integer pageSize, @RequestParam Integer pageNum) {
        List<JobInst> jobInsts = jobInstService.list();
        return ResponseVO.ok(jobInsts);
    }


    /**
     * 创建JOB
     *
     * @return
     */
    @PostMapping(value = "/job", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO createJob(@RequestParam String jobName,
                                @RequestParam String jobGroup,
                                @RequestParam String cronExpress) {
        scheduleService.newJob();
        return ResponseVO.ok();
    }


    /**
     * 暂停 JOB
     *
     * @return
     */
    @PostMapping(value = "/job/pause", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO pauseJob() {
        scheduleService.pauseJob();
        return ResponseVO.ok();
    }


    /**
     * 重新开始 JOB
     *
     * @return
     */
    @PostMapping(value = "/job/start", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO startJob() {
        scheduleService.starJob();
        return ResponseVO.ok();
    }

    /**
     * 删除 | 取消 JOB
     *
     * @return
     */
    @PostMapping(value = "/job/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO delJob() {
        scheduleService.delJob();
        return ResponseVO.ok();
    }


}

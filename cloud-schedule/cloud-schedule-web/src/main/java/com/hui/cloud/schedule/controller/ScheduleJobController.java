package com.hui.cloud.schedule.controller;

import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.schedule.entity.Job;
import com.hui.cloud.schedule.service.JobService;
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
@RequestMapping("/schedule")
public class ScheduleJobController {

    private ScheduleService scheduleService;

    private JobService jobService;

    @Autowired
    public ScheduleJobController(ScheduleService scheduleService, JobService jobService) {
        this.scheduleService = scheduleService;
        this.jobService = jobService;
    }

    /**
     * 分页查询JOB实例
     * @return
     */
    @GetMapping(value = "/jobs",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listJobs(@RequestParam Integer pageSize,@RequestParam Integer pageNum){
        List<Job> jobList = jobService.list();
        return ResponseVO.ok(jobList);
    }


    /**
     * 创建JOB
     * @return
     */
    @PostMapping(value = "/job",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO createJob(){
        scheduleService.newJob();
        return ResponseVO.ok();
    }


    /**
     * 暂停 JOB
     * @return
     */
    @PostMapping(value = "/job/pause",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO pauseJob(){
        scheduleService.pauseJob();
        return ResponseVO.ok();
    }


    /**
     * 重新开始 JOB
     * @return
     */
    @PostMapping(value = "/job/start",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO startJob(){
        scheduleService.starJob();
        return ResponseVO.ok();
    }

    /**
     * 删除 | 取消 JOB
     * @return
     */
    @PostMapping(value = "/job/del",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO delJob(){
        return ResponseVO.ok();
    }


}

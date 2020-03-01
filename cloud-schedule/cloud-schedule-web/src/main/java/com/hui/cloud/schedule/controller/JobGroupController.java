package com.hui.cloud.schedule.controller;


import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.schedule.entity.JobGroup;
import com.hui.cloud.schedule.service.JobGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * JOB组 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2019-11-16
 */
@RestController
public class JobGroupController {
    private JobGroupService jobGroupService;

    @Autowired
    public JobGroupController(JobGroupService jobGroupService) {
        this.jobGroupService = jobGroupService;
    }

    @PostMapping(value = "/job-group", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO createJobGroup(@RequestBody JobGroup jobGroup) {
        jobGroupService.save(jobGroup);
        return ResponseVO.ok();
    }

    @PutMapping(value = "/job-group", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO updateJobGroup(@RequestBody JobGroup jobGroup) {
        jobGroupService.updateById(jobGroup);
        return ResponseVO.ok();
    }

    @DeleteMapping(value = "/job-group/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO deleteJobGroup(@PathVariable("id") Long jobGroupId) {
        jobGroupService.removeById(jobGroupId);
        return ResponseVO.ok();
    }

    @GetMapping(value = "/job-groups", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listJobGroups(@RequestParam("pageNum") Integer pageNum,
                                    @RequestParam("pageSize") Integer pageSize) {
        List<JobGroup> jobGroups = jobGroupService.listByPage(pageNum, pageSize);
        return ResponseVO.ok(jobGroups);
    }

}


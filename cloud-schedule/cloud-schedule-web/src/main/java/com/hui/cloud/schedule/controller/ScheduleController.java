package com.hui.cloud.schedule.controller;

import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class ScheduleController {
    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(value = "/jobs",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listJobs(){
        return ResponseVO.ok();
    }

}

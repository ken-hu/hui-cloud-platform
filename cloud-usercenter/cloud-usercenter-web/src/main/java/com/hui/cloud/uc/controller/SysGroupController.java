package com.hui.cloud.uc.controller;


import com.hui.cloud.uc.service.SysGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 组表 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-20
 */
@RestController
@RequestMapping("/sys-group")
public class SysGroupController {

    private SysGroupService sysGroupService;

    @Autowired
    public SysGroupController(SysGroupService sysGroupService) {
        this.sysGroupService = sysGroupService;
    }

}


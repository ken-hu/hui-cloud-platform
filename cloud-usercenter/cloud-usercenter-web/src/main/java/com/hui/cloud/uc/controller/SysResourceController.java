package com.hui.cloud.uc.controller;


import com.hui.cloud.uc.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/sys-resource")
public class SysResourceController {

    private SysResourceService sysResourceService;

    @Autowired
    public SysResourceController(SysResourceService sysResourceService) {
        this.sysResourceService = sysResourceService;
    }

}


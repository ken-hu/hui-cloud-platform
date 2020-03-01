package com.hui.cloud.uc.controller;


import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.SysResourceDTO;
import com.hui.cloud.uc.entity.Resource;
import com.hui.cloud.uc.service.ResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
@RestController
public class ResourceController {

    private ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }


    /**
     * 创建OR更新Resource
     * @param sysResourceDTO
     * @return
     */
    @PostMapping(value = "/resource",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO saveResource(@RequestBody SysResourceDTO sysResourceDTO){
        Resource sysResource = new Resource();
        BeanUtils.copyProperties(sysResourceDTO, sysResource);
        resourceService.saveOrUpdate(sysResource);
        return ResponseVO.ok();
    }
}


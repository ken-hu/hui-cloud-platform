package com.hui.cloud.uc.controller;


import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.SysPermissionDTO;
import com.hui.cloud.uc.entity.SysPermission;
import com.hui.cloud.uc.entity.SysResource;
import com.hui.cloud.uc.service.SysPermissionService;
import com.hui.cloud.uc.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-20
 */
@RestController
public class SysPermissionController {

    private SysResourceService sysResourceService;

    private SysPermissionService sysPermissionService;

    @Autowired
    public SysPermissionController(SysResourceService sysResourceService, SysPermissionService sysPermissionService) {
        this.sysResourceService = sysResourceService;
        this.sysPermissionService = sysPermissionService;
    }

    /**
     * 查看权限拥有的资源
     * @param permissionId
     * @return
     */
    @GetMapping(value = "/permission/{id}/resources", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listResources(@PathVariable("id") Long permissionId) {
        HashSet<SysResource> sysResources = sysResourceService.listByPermissionId(permissionId);
        return ResponseVO.ok(sysResources);
    }


    /**
     * 权限绑定资源
     * @param permissionId
     * @param resourcesIds
     * @return
     */
    @PutMapping(value = "/permission/{id}/resources",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO bindResources(@PathVariable("id") Long permissionId, @RequestParam List<Long> resourcesIds){
        sysPermissionService.bindResource(resourcesIds, permissionId);
        return ResponseVO.ok();
    }


    /**
     * 创建OR更新权限
     * @param sysPermissionDTO
     * @return
     */
    @PostMapping(value = "/permission",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO savePermission(@RequestBody SysPermissionDTO sysPermissionDTO){
        SysPermission sysPermission = new SysPermission();
        sysPermissionService.saveOrUpdate(sysPermission);
        return ResponseVO.ok();
    }

}


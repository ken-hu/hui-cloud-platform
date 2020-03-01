package com.hui.cloud.uc.controller;


import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.SysPermissionDTO;
import com.hui.cloud.uc.entity.Permission;
import com.hui.cloud.uc.entity.Resource;
import com.hui.cloud.uc.service.PermissionService;
import com.hui.cloud.uc.service.ResourceService;
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
 * @since 2020-02-23
 */
@RestController
public class PermissionController {
    private ResourceService resourceService;

    private PermissionService permissionService;


    /**
     * 查看权限拥有的资源
     * @param permissionId
     * @return
     */
    @GetMapping(value = "/permission/{id}/resources", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listResources(@PathVariable("id") Long permissionId) {
        HashSet<Resource> sysResources = resourceService.listByPermissionId(permissionId);
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
        permissionService.bindResource(resourcesIds, permissionId);
        return ResponseVO.ok();
    }


    /**
     * 创建OR更新权限
     * @param sysPermissionDTO
     * @return
     */
    @PostMapping(value = "/permission",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO savePermission(@RequestBody SysPermissionDTO sysPermissionDTO){
        Permission sysPermission = new Permission();
        permissionService.saveOrUpdate(sysPermission);
        return ResponseVO.ok();
    }

}


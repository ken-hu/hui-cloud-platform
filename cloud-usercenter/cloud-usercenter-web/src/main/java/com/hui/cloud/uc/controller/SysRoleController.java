package com.hui.cloud.uc.controller;


import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.SysRoleDTO;
import com.hui.cloud.uc.entity.SysRole;
import com.hui.cloud.uc.service.SysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
@RestController
public class SysRoleController {

    private SysRoleService sysRoleService;

    @Autowired
    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    /**
     * 查询角色列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/roles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listRoles(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<SysRole> sysRoles = sysRoleService.listByPage(pageNum, pageSize);
        return ResponseVO.ok(sysRoles);
    }

    /**
     * 角色绑定权限
     *
     * @param permissionId
     * @param roleId
     * @return
     */
    @PutMapping(value = "/role/{id}/permissions", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO bindPermissions(@PathVariable("id") Long roleId, @RequestParam List<Long> permissionId) {
        sysRoleService.bindPermissions(permissionId, roleId);
        return ResponseVO.ok();
    }

    /**
     * 创建OR更新角色
     * @param sysRoleDTO
     * @return
     */
    @PostMapping(value = "/role",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO saveRole(@RequestBody SysRoleDTO sysRoleDTO){
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleDTO,sysRole);
        sysRoleService.saveOrUpdate(sysRole);
        return ResponseVO.ok(sysRole);
    }

}


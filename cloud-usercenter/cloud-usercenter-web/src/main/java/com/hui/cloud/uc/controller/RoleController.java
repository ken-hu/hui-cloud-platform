package com.hui.cloud.uc.controller;


import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.SysRoleDTO;
import com.hui.cloud.uc.entity.Role;
import com.hui.cloud.uc.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
@RestController
public class RoleController {

    private RoleService roleService;

    /**
     * 查询角色列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/roles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listRoles(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<Role> sysRoles = roleService.listByPage(pageNum, pageSize);
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
        roleService.bindPermissions(permissionId, roleId);
        return ResponseVO.ok();
    }

    /**
     * 创建OR更新角色
     * @param sysRoleDTO
     * @return
     */
    @PostMapping(value = "/role",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO saveRole(@RequestBody SysRoleDTO sysRoleDTO){
        Role sysRole = new Role();
        BeanUtils.copyProperties(sysRoleDTO,sysRole);
        roleService.saveOrUpdate(sysRole);
        return ResponseVO.ok(sysRole);
    }

}


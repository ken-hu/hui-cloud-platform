package com.hui.cloud.uc.controller;


import com.hui.cloud.auth.api.AuthClient;
import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.SysUserDTO;
import com.hui.cloud.uc.entity.SysGroup;
import com.hui.cloud.uc.entity.SysRole;
import com.hui.cloud.uc.entity.SysUser;
import com.hui.cloud.uc.service.SysGroupService;
import com.hui.cloud.uc.service.SysRoleService;
import com.hui.cloud.uc.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    private SysUserService sysUserService;

    private SysRoleService sysRoleService;

    private SysGroupService sysGroupService;

    private AuthClient authClient;

    @Autowired
    public SysUserController(SysUserService sysUserService, SysRoleService sysRoleService, SysGroupService sysGroupService, AuthClient authClient) {
        this.sysUserService = sysUserService;
        this.sysRoleService = sysRoleService;
        this.sysGroupService = sysGroupService;
        this.authClient = authClient;
    }

    /**
     * 用户名查询用户
     *
     * @param userName
     * @return
     */
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO getSysUser(@RequestParam String userName) {
        SysUser sysUser = sysUserService.getUserByName(userName);
        SysUserDTO sysUserDTO = new SysUserDTO();
        BeanUtils.copyProperties(sysUser, sysUserDTO);
        return ResponseVO.ok(sysUserDTO);
    }

    /**
     * 分页查询用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listSysUser(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<SysUser> sysUsers = sysUserService.listByPage(pageNum, pageSize);
        return ResponseVO.ok(sysUsers);
    }

    /**
     * 查询用户的角色
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/user/{id}/roles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listUserRoles(@PathVariable("id") Long userId) {
        HashSet<SysRole> sysRoles = sysRoleService.listByUserId(userId);
        return ResponseVO.ok(sysRoles);
    }

    /**
     * 查询用户的组
     *
     * @return
     */
    @GetMapping(value = "/user/{id}/groups", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listUserGroups(@PathVariable("id") Long userId) {
        HashSet<SysGroup> sysGroups = sysGroupService.listByUserId(userId);
        return ResponseVO.ok(sysGroups);
    }

    /**
     * 用户绑定角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
    @PutMapping(value = "/user/{id}/roles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO bindRoles(@PathVariable("id") Long userId, @RequestParam List<Long> roleIds) {
        sysUserService.bindRoles(roleIds, userId);
        return ResponseVO.ok();
    }

    /**
     * 用户绑定用户组
     *
     * @param userId
     * @param groupIds
     * @return
     */
    @PutMapping(value = "/user/{id}/groups", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO bindGroups(@PathVariable("id") Long userId, @RequestParam List<Long> groupIds) {
        sysUserService.bindGroups(groupIds, userId);
        return ResponseVO.ok();
    }

}


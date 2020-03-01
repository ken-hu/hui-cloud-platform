package com.hui.cloud.uc.controller;


import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.SysUserDTO;
import com.hui.cloud.uc.entity.Group;
import com.hui.cloud.uc.entity.Permission;
import com.hui.cloud.uc.entity.Role;
import com.hui.cloud.uc.entity.User;
import com.hui.cloud.uc.service.GroupService;
import com.hui.cloud.uc.service.PermissionService;
import com.hui.cloud.uc.service.RoleService;
import com.hui.cloud.uc.service.UserService;
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
 * @since 2020-02-23
 */
@RestController
public class UserController {

    private UserService userService;
    private PermissionService permissionService;
    private RoleService roleService;
    private GroupService groupService;

    @Autowired
    public UserController(UserService userService, PermissionService permissionService, RoleService roleService, GroupService groupService) {
        this.userService = userService;
        this.permissionService = permissionService;
        this.roleService = roleService;
        this.groupService = groupService;
    }


    /**
     * 用户名查询用户
     *
     * @param userName
     * @return
     */
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO getSysUser(@RequestParam String userName) {
        User user = userService.getUserByName(userName);
        SysUserDTO sysUserDTO = new SysUserDTO();
        BeanUtils.copyProperties(user, sysUserDTO);
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
        List<User> sysUsers = userService.listByPage(pageNum, pageSize);
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
        HashSet<Role> sysRoles = roleService.listByUserId(userId);
        return ResponseVO.ok(sysRoles);
    }


    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    @GetMapping(value = "/user/{id}/permissions", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listUserPermissions(@PathVariable("id") Long userId) {
        HashSet<Permission> sysPermissions = permissionService.listByUserId(userId);
        return ResponseVO.ok(sysPermissions);
    }

    /**
     * 查询用户的组
     *
     * @return
     */
    @GetMapping(value = "/user/{id}/groups", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listUserGroups(@PathVariable("id") Long userId) {
        HashSet<Group> sysGroups = groupService.listByUserId(userId);
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
        userService.bindRoles(roleIds, userId);
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
        userService.bindGroups(groupIds, userId);
        return ResponseVO.ok();
    }
}


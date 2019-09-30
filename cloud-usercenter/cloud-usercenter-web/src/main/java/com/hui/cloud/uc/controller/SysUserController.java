package com.hui.cloud.uc.controller;


import com.hui.cloud.auth.api.AuthClient;
import com.hui.cloud.auth.dto.AuthTokenDTO;
import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.RegisterRequestDTO;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
     * 用户注册
     *
     * @param registerRequestDTO
     * @return
     */
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        SysUser sysUser = new SysUser();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(registerRequestDTO.getPassword());
        sysUser.setUserName(registerRequestDTO.getUserName());
        sysUser.setPassword(encodePassword);
        sysUserService.save(sysUser);
        return ResponseVO.ok();
    }


    /**
     * 用户登录
     * @param authorization
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO login(@RequestParam(value = "authorization") String authorization,
                            @RequestParam("username") String username,
                            @RequestParam("password") String password) {

        System.out.println(authorization);

        String test = authClient.test();
        System.out.println(test);


        AuthTokenDTO jwt= authClient.getToken(authorization, username, password, "password");
        return ResponseVO.ok(jwt);
    }


    /**
     * 用户名查询用户
     *
     * @param userName
     * @return
     */
    @GetMapping("/user")
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
    @GetMapping("/users")
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
    @GetMapping("/user/{id}/roles")
    public ResponseVO listUserRoles(@PathVariable("id") Long userId) {
        HashSet<SysRole> sysRoles = sysRoleService.listByUserId(userId);
        return ResponseVO.ok(sysRoles);
    }

    /**
     * 查询用户的组
     *
     * @return
     */
    @GetMapping("/user/{id}/groups")
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
    @PutMapping("/user/{id}/roles")
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
    @PutMapping("/user/{id}/groups")
    public ResponseVO bindGroups(@PathVariable("id") Long userId, @RequestParam List<Long> groupIds) {
        sysUserService.bindGroups(groupIds, userId);
        return ResponseVO.ok();
    }

}


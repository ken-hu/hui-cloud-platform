package com.hui.cloud.uc.user.controller;


import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.user.model.entity.SysRole;
import com.hui.cloud.uc.user.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/user/sys-role")
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
    @GetMapping("/roles")
    public ResponseVO listRoles(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<SysRole> sysRoles = sysRoleService.listByPage(pageNum, pageSize);
        return ResponseVO.ok(sysRoles);
    }
}


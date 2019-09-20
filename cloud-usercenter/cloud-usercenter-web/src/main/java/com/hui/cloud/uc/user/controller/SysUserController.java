package com.hui.cloud.uc.user.controller;


import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.user.dto.SysUserDTO;
import com.hui.cloud.uc.user.model.entity.SysUser;
import com.hui.cloud.uc.user.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/user/sys-user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/user")
    public ResponseVO<SysUserDTO> getSysUser(@RequestParam String userName){
        SysUser sysUser = sysUserService.getUserByName(userName);
        SysUserDTO sysUserDTO = new SysUserDTO();
        BeanUtils.copyProperties(sysUser,sysUserDTO);
        return ResponseVO.ok(sysUserDTO);
    }


}


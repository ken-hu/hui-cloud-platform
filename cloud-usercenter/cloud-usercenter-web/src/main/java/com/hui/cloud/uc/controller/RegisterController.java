package com.hui.cloud.uc.controller;

import com.hui.cloud.auth.api.AuthClient;
import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.RegisterRequestDTO;
import com.hui.cloud.uc.entity.SysUser;
import com.hui.cloud.uc.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <code>RegisterController</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/1 11:02.
 *
 * @author Gary.Hu
 */
@RestController
@RequestMapping("/sys-user")
public class RegisterController {

    private SysUserService sysUserService;

    private AuthClient authClient;

    @Autowired
    public RegisterController(SysUserService sysUserService, AuthClient authClient) {
        this.sysUserService = sysUserService;
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
}

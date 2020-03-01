package com.hui.cloud.uc.controller;

import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.RegisterRequestDTO;
import com.hui.cloud.uc.entity.User;
import com.hui.cloud.uc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册
     *
     * @param registerRequestDTO
     * @return
     */
    @PostMapping(value = "/user/register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(registerRequestDTO.getPassword());
        User sysUser = new User();
        sysUser.setUserName(registerRequestDTO.getUserName());
        sysUser.setPassword(encodePassword);
        userService.save(sysUser);
        return ResponseVO.ok();
    }
}

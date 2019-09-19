package com.hui.cloud.auth.oauth.service.impl;

import com.hui.cloud.auth.oauth.model.bo.AuthUserDetail;
import com.hui.cloud.uc.user.api.SysUserApi;
import com.hui.cloud.uc.user.dto.SysUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <b><code>UserDetailsServiceImpl</code></b>
 * <p/>
 * 授权用户Service
 * <p/>
 * <b>Creation Time:</b> 2019/3/14 22:54.
 *
 * @author HuWeihui
 */
@Service
@Slf4j
public class AuthUserDetailsService implements UserDetailsService {

    private SysUserApi sysUserApi;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthUserDetailsService(SysUserApi sysUserApi, PasswordEncoder passwordEncoder) {
        this.sysUserApi = sysUserApi;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserDTO sysUserDTO = sysUserApi.getSysUser(username).getData();
        log.info(sysUserDTO.toString());
        if (null == sysUserDTO) {
            throw new UsernameNotFoundException("Not found this username : " + username);
        }
        AuthUserDetail authUserDetail = new AuthUserDetail();
        BeanUtils.copyProperties(sysUserDTO, authUserDetail);
        authUserDetail.setPassword(passwordEncoder.encode(sysUserDTO.getPassword()));
        return authUserDetail;
    }

}

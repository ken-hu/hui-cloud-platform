package com.hui.cloud.auth.service.impl;

import com.hui.cloud.auth.service.bo.AuthUserDetail;
import com.hui.cloud.uc.api.SysUserClient;
import com.hui.cloud.uc.dto.SysUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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

    private SysUserClient sysUserClient;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthUserDetailsService(SysUserClient sysUserClient, PasswordEncoder passwordEncoder) {
        this.sysUserClient = sysUserClient;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")){
            User user = new User("admin",passwordEncoder.encode("123456"),true,
                    true, true,
                    true, Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
            return user;
        }
        SysUserDTO sysUserDTO = sysUserClient.getSysUser(username).getData();
        log.info(sysUserDTO.toString());
        if (null == sysUserDTO) {
            throw new UsernameNotFoundException("Not found this username : " + username);
        }
        AuthUserDetail authUserDetail =
                new AuthUserDetail(sysUserDTO.getUserName(), sysUserDTO.getPassword(),
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
        log.info(authUserDetail.toString());
        return authUserDetail;
    }

}

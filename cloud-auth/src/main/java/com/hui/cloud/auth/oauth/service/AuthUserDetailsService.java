package com.hui.cloud.auth.oauth.service;

import com.hui.cloud.auth.oauth.model.AuthUserDetail;
import com.hui.cloud.uc.auth.mapper.UserMapper;
import com.hui.cloud.uc.auth.model.entity.User;
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
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2019/3/14 22:54.
 *
 * @author HuWeihui
 */
@Service
@Slf4j
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectByUserName(username);
        log.info(user.toString());
        if (null == user) {
            throw new UsernameNotFoundException("not fond username :" + username);
        }
        AuthUserDetail authUserDetail = new AuthUserDetail();
        BeanUtils.copyProperties(user, authUserDetail);
        authUserDetail.setPassword(passwordEncoder.encode(user.getLoginPwd()));
        return authUserDetail;
    }

}

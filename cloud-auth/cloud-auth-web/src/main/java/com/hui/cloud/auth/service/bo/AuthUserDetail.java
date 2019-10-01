package com.hui.cloud.auth.service.bo;

import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * <b><code>AuthRoleDetail</code></b>
 * <p/>
 * 授权用户
 * <p/>
 * <b>Creation Time:</b> 2019/9/19 22:39.
 *
 * @author Gary.hu
 */
@ToString
public class AuthUserDetail implements UserDetails{

    private String username;
    private String password;
    private List<GrantedAuthority> grantedAuthorities;

    public AuthUserDetail(String username, String password, List<GrantedAuthority> grantedAuthorities) {
        this.username = username;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

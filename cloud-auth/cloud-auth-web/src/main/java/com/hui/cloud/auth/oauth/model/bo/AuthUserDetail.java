package com.hui.cloud.auth.oauth.model.bo;

import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * <b><code>AuthRoleDetail</code></b>
 * <p/>
 * 授权用户
 * <p/>
 * <b>Creation Time:</b> 2019/9/19 22:39.
 *
 * @author Gary.hu
 */
@Setter
public class AuthUserDetail implements UserDetails {
    private String userName;

    private String password;

    Collection<? extends GrantedAuthority> grantedAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
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

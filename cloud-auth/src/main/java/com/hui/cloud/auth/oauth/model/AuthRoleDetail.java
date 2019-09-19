package com.hui.cloud.auth.oauth.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * <b><code>AuthRoleDetail</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2019/3/17 22:39.
 *
 * @author HuWeihui
 */
public class AuthRoleDetail implements GrantedAuthority {

    private String roleId;

    private String roleName;

    @Override
    public String getAuthority() {
        return this.roleName;
    }

}

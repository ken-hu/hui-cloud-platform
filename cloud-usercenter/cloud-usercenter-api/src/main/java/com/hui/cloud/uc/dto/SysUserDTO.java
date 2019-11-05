package com.hui.cloud.uc.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <b><code>UserDTO</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2019/9/19 11:36.
 *
 * @author Gary.Hu
 */
@Data
public class SysUserDTO implements Serializable {
    private static final long serialVersionUID = -1097540993472283459L;

    private Long userId;

    private String userName;

    private String password;
}

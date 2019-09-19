package com.hui.cloud.uc.user.dto;

import lombok.Data;

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
public class SysUserDTO {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 是否逻辑删除 1：已删除 0：未删除
     */
    private Integer deleted;
}

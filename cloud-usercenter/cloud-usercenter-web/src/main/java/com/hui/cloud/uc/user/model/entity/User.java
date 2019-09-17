package com.hui.cloud.uc.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hui.cloud.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_uc_user")
public class User extends BaseEntity<User> {

    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.NONE)
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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 修改用户
     */
    private String modifyUser;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}

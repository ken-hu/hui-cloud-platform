package com.hui.cloud.uc.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资源-权限-关联表
 * </p>
 *
 * @author Gary.hu
 * @since 2019-10-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_uc_sys_resource_permission_rel")
public class SysResourcePermissionRel extends Model<SysResourcePermissionRel> {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 资源ID
     */
    @TableField("resource_id")
    private String resourceId;

    /**
     * 权限ID
     */
    @TableField("permission_id")
    private String permissionId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 创建用户
     */
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    /**
     * 修改用户
     */
    @TableField(value = "modify_user", fill = FieldFill.INSERT_UPDATE)
    private String modifyUser;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

package com.hui.cloud.uc.user.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 组表
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_uc_sys_group")
public class SysGroup extends Model<SysGroup> {

    private static final long serialVersionUID=1L;

    /**
     * 组ID
     */
    @TableId(value = "group_id", type = IdType.NONE)
    private Long groupId;

    /**
     * 组代码
     */
    @TableField("group_code")
    private String groupCode;

    /**
     * 组名字
     */
    @TableField("group_name")
    private String groupName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createTime;

    /**
     * 创建用户
     */
    @TableField(value = "create_user", fill = FieldFill.INSERT_UPDATE)
    private String createUser;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.UPDATE)
    private LocalDateTime modifyTime;

    /**
     * 修改用户
     */
    @TableField(value = "modify_user", fill = FieldFill.UPDATE)
    private String modifyUser;


    @Override
    protected Serializable pkVal() {
        return this.groupId;
    }

}

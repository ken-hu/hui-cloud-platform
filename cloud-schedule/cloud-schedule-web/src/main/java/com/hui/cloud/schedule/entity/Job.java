package com.hui.cloud.schedule.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 调度JOB
 * </p>
 *
 * @author Gary.hu
 * @since 2019-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_schedule_job")
public class Job extends Model<Job> {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.NONE)
    private String id;

    /**
     * 调度器名字
     */
    @TableField("schedule_name")
    private String scheduleName;

    /**
     * Job名字
     */
    @TableField("job_name")
    private String jobName;

    /**
     * Job组
     */
    @TableField("job_group")
    private String jobGroup;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * JOB类路径
     */
    @TableField("job_class_name")
    private String jobClassName;

    /**
     * cron表达式
     */
    @TableField("cron_expression")
    private String cronExpression;

    /**
     * 是否逻辑删除 1：已删除 0：未删除
     */
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;

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

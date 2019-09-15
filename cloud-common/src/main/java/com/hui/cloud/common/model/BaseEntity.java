package com.hui.cloud.common.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * <b><code>BaseEntity</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/15 0:38.
 *
 * @author Hu-Weihui
 */
@Data
@MappedSuperclass
public class BaseEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time")
    private Date createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_time")
    private Date modifyTime;

    @Column(name = "created_user")
    private String createdUser;

    @Column(name = "modify_user")
    private String modifyUser;
}

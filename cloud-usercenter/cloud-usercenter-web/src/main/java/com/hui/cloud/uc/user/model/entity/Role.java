package com.hui.cloud.uc.user.model.entity;

import com.hui.cloud.common.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <b><code>Role</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/14 22:56.
 *
 * @author Hu-Weihui
 */
@Entity
@Table(name = "t_uc_role")
@DynamicInsert
@DynamicUpdate
@Data
public class Role extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -8216000633124798421L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id")
    @GenericGenerator(name = "id", strategy = "com.hui.cloud.common.utils.IdGenerator")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_code")
    private String roleCode;

}

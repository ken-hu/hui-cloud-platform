package com.hui.cloud.uc.user.model.entity;

import com.hui.cloud.common.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <b><code>User</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/13 1:52.
 *
 * @author Hu-Weihui
 */
@Entity
@Table(name = "t_uc_user")
@DynamicInsert
@DynamicUpdate
@Data
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 3382454162215811217L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id")
    @GenericGenerator(name = "id", strategy = "com.hui.cloud.common.utils.IdGenerator")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

}

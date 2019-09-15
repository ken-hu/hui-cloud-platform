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
 * <b><code>Resource</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/14 22:56.
 *
 * @author Hu-Weihui
 */
@Entity
@Table(name = "t_uc_resource")
@DynamicInsert
@DynamicUpdate
@Data
public class Resource extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4478511991521815355L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id")
    @GenericGenerator(name = "id", strategy = "com.hui.cloud.common.utils.IdGenerator")
    private Long resourceId;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "resource_code")
    private String resourceCode;

    @Column(name = "resource_type")
    private String resourceType;

    @Column(name = "resource_uri")
    private String resourceUri;

    @Column(name = "resource_request_type")
    private String resourceRequestType;

    @Column(name = "resource_parent_id")
    private String resourceParentId;

}

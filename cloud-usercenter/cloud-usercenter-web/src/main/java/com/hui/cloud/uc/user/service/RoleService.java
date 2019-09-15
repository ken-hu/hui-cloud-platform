package com.hui.cloud.uc.user.service;

import com.hui.cloud.uc.user.model.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b><code>RoleService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/15 16:59.
 *
 * @author Hu-Weihui
 */
@Repository
public interface RoleService {

    /**
     * 查询用户的角色
     * @param userId
     * @return
     */
    List<Role> listByUserId(Long userId);

}

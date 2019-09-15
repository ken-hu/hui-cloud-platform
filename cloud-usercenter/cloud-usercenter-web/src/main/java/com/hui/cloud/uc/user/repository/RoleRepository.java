package com.hui.cloud.uc.user.repository;

import com.hui.cloud.uc.user.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <b><code>RoleRepository</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/15 17:06.
 *
 * @author Hu-Weihui
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
    /**
     * 通过UserId查询角色列表
     * @param userId
     * @return
     */
    List<Role> findByUserId(Long userId);
}

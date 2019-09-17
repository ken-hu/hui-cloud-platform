package com.hui.cloud.uc.user.service;

import com.hui.cloud.uc.user.model.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-18
 */
public interface RoleService extends IService<Role> {

    /**
     * 新增角色
     * @param role
     * @return
     */
    Role addRole(Role role);

    /**
     * 更新角色信息
     * @param role
     * @return
     */
    int updateRole(Role role);
}

package com.hui.cloud.uc.user.service.impl;

import com.hui.cloud.uc.user.model.entity.Role;
import com.hui.cloud.uc.user.mapper.RoleMapper;
import com.hui.cloud.uc.user.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-18
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public Role addRole(Role role) {
        return null;
    }

    @Override
    public int updateRole(Role role) {
        return 0;
    }
}

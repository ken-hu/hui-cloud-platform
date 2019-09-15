package com.hui.cloud.uc.user.service.impl;

import com.hui.cloud.uc.user.model.entity.Role;
import com.hui.cloud.uc.user.repository.RoleRepository;
import com.hui.cloud.uc.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <b><code>RoleServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/15 16:59.
 *
 * @author Hu-Weihui
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> listByUserId(Long userId) {
        List<Role> roles = roleRepository.findByUserId(userId);
        return roles;
    }
}

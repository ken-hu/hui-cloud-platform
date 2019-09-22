package com.hui.cloud.uc.service;

import com.hui.cloud.uc.entity.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

/**
 * <code>SysRoleServiceTest</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/9/21 13:26.
 *
 * @author Gary.Hu
 */
@Slf4j
public class SysRoleServiceTest extends BaseJunitTest{
    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void listByPageTest(){
        List<SysRole> sysRoles = sysRoleService.listByPage(1, 2);
        sysRoles.forEach(x->log.info(x.toString()));
    }

    @Test
    public void listByUserIdTest(){
        HashSet<SysRole> sysRoles = sysRoleService.listByUserId(1L);
        sysRoles.forEach(x->log.info(x.toString()));
    }

    @Test
    public void listByGroupIdTest(){
        HashSet<SysRole> sysRoles = sysRoleService.listByGroupId(1L);
        sysRoles.forEach(x->log.info(x.toString()));
    }
}

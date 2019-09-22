package com.hui.cloud.uc.user.service;

import com.hui.cloud.uc.user.model.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <b><code>UserService</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2019/9/18 11:49.
 *
 * @author Gary.Hu
 */
@Slf4j
public class SysUserServiceTest extends BaseJunitTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void getUserByNameTest() throws Exception{
        SysUser sysUser = sysUserService.getUserByName("admin");
        log.info(sysUser.toString());
    }

    @Test
    public void listByPage() throws Exception{
        List<SysUser> sysUsers = sysUserService.listByPage(1, 2);
        sysUsers.forEach(x->log.info(x.toString()));
    }

}

package com.hui.cloud.uc.common;

import com.hui.cloud.uc.user.model.entity.SysUser;
import com.hui.cloud.uc.user.service.BaseJunitTest;
import com.hui.cloud.uc.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}

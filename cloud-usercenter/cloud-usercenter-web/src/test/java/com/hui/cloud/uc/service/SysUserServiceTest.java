package com.hui.cloud.uc.service;

import com.hui.cloud.uc.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    @Test
    public void bindRoles() throws Exception{
        List<Long> roleIds = Arrays.asList(1L, 2L, 3L);
        sysUserService.bindRoles(roleIds,1L);
    }

    @Test
    public void bindGroups(){
        List<Long> groupIds = Arrays.asList(1L, 2L, 3L);
        sysUserService.bindGroups(groupIds,1L);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_uc_sys_user_group_rel");
        maps.forEach(x -> log.info(x.toString()));
    }

}

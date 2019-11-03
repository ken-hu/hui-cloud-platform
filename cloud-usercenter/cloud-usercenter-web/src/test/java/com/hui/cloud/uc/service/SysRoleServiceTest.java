package com.hui.cloud.uc.service;

import com.google.common.collect.Sets;
import com.hui.cloud.uc.BaseJunitTest;
import com.hui.cloud.uc.entity.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Base64;
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
public class SysRoleServiceTest extends BaseJunitTest {
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

    @Test
    public void testClientSecurit() throws IOException {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");


        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text = "dXNlcmNlbnRlci1zZXJ2aWNlOjEyMzQ1Ng==";
        final byte[] textByte = text.getBytes("UTF-8");
        //编码
        final String encodedText = new String(decoder.decode(text),"UTF-8");

        log.info(encodedText);
        log.info(encode);
    }


    @Test
    public void testSet(){
        String field = "usercenter-service";
        log.info(field);
        String[] split = StringUtils.split(field, ",");
        log.info(split.toString());
        Sets.newHashSet(field);
    }
}

package com.hui.cloud.uc.api;

import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.SysUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b><code>SysUserApi</code></b>
 * <p>
 *     usercenter-service提供的API
 * <p/>
 * <b>Creation Time:</b> 2019/9/19 14:18.
 *
 * @author Gary.Hu
 */
@FeignClient(value = "usercenter-service" , path = "/sys-user",fallback = SysUserClient.SysUserClientFallBack.class)
public interface SysUserClient {

    @GetMapping(value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseVO<SysUserDTO> getSysUser(@RequestParam String userName);

    /**
     * 服务降级处理
     */
    class SysUserClientFallBack implements SysUserClient {
        @Override
        public ResponseVO<SysUserDTO> getSysUser(String userName) {
            return null;
        }
    }
}
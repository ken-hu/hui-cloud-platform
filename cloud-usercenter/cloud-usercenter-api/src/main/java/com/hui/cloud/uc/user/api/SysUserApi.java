package com.hui.cloud.uc.user.api;

import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.user.dto.SysUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
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
@FeignClient(name = "usercenter-service" , fallback = SysUserApi.SysUserApiFallBack.class)
public interface SysUserApi {
    @GetMapping("")
    ResponseVO<SysUserDTO> getSysUser(@RequestParam String userName);

    /**
     * 服务降级处理
     */
    class SysUserApiFallBack implements SysUserApi{
        @Override
        public ResponseVO<SysUserDTO> getSysUser(String userName) {
            return null;
        }
    }
}
package com.hui.cloud.auth.api;

import com.hui.cloud.auth.dto.AuthTokenDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <code>AuthClient</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/9/30 23:12.
 *
 * @author Gary.Hu
 */
@FeignClient(value = "auth-service")
public interface AuthClient {
    @PostMapping(value = "/oauth/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    AuthTokenDTO getToken(@RequestHeader(value = "Authorization") String authorization,
                          @RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("grant_type") String grantType);


    @PostMapping(value = "/oauth/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    AuthTokenDTO refreshToken(@RequestHeader(value = "Authorization") String authorization,
                              @RequestParam("refresh_token") String refreshToken,
                              @RequestParam("grant_type") String grantType);
}

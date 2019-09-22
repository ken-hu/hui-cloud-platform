package com.hui.cloud.auth.api;

import com.hui.cloud.auth.dto.AuthTokenDTO;
import com.hui.cloud.common.model.ResponseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <code>AuthApi</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/9/22 23:44.
 *
 * @author Gary.Hu
 */
@FeignClient(name = "auth-service", fallback = AuthApi.AuthApiFallback.class)
public interface AuthApi {

    @PostMapping(value = "/oauth/token",
            consumes = "application/x-www-form-urlencoded", produces = "application/json")
    ResponseVO<AuthTokenDTO> getToken(@RequestParam String username,
                                      @RequestParam String password,
                                      @RequestParam String grantType);


    @PostMapping(value = "/oauth/token",
            consumes = "application/x-www-form-urlencoded", produces = "application/json")
    ResponseVO<AuthTokenDTO> refreshToken(@RequestParam String refreshToken,
                            @RequestParam String grantType);

    class AuthApiFallback implements AuthApi{
        @Override
        public ResponseVO<AuthTokenDTO> getToken(String username, String password, String grantType) {
            return null;
        }

        @Override
        public ResponseVO<AuthTokenDTO> refreshToken(String refreshToken, String grantType) {
            return null;
        }
    }
}

package com.hui.cloud.auth.oauth.handler;

import com.hui.cloud.common.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * <b><code>AuthWebResponseExceptionHandler</code></b>
 * <p/>
 * Description: 异常转换处理
 * <p/>
 * <b>Creation Time:</b> 2019/3/19 21:41.
 *
 * @author HuWeihui
 */
@Component
@Slf4j
public class AuthWebResponseExceptionHandler implements WebResponseExceptionTranslator {

    @Override
    public ResponseEntity translate(Exception e) throws Exception {
        log.error("AuthService 发生异常 ", e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseVO.error(e.getMessage()));
    }

}

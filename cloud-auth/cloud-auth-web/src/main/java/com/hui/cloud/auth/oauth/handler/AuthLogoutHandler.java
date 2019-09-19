package com.hui.cloud.auth.oauth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hui.cloud.common.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <b><code>AuthLogoutHandler</code></b>
 * <p/>
 * 退出登录成功处理
 * <p/>
 * <b>Creation Time:</b> 2019/3/12 23:51.
 *
 * @author HuWeihui
 */
@Slf4j
public class AuthLogoutHandler implements LogoutSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Authentication authentication)  {
        try {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(ResponseVO.ok("成功退出")));
            log.info("User logout Successful !!!");
        } catch (IOException e) {
            log.error("User logout Fail !!!",e);
        }
    }
}

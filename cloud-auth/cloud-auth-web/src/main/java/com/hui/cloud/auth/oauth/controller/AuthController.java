package com.hui.cloud.auth.oauth.controller;

import com.hui.cloud.common.model.ResponseVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <code>AuthController</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/9/22 19:34.
 *
 * @author Gary.Hu
 */
@RestController
@RequestMapping("/oauth/auth")
public class AuthController {
    @PostMapping
    public ResponseVO login(HttpServletRequest servletRequest, HttpServletResponse servletResponse){

        return null;
    }

}

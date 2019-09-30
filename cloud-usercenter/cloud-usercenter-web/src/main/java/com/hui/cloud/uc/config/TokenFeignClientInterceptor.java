package com.hui.cloud.uc.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <code>TokenFeignClientInterceptor</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/9/30 1:12.
 *
 * @author Gary.Hu
 */
//@Configuration
public class TokenFeignClientInterceptor implements RequestInterceptor {

    /**
     * token放在请求头.
     *
     * @param requestTemplate 请求参数
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            String token = request.getHeader("Authorization");
            requestTemplate.header("Authorization",
                    token);
        }
    }
}

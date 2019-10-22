package com.hui.cloud.common.config;

import com.hui.cloud.common.handler.RequestDateConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

/**
 * <code>WebConfig</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/11 23:44.
 *
 * @author Gary.Hu
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    /**
     *日期转换. 支持 yyyy-MM-dd HH:mm:ss 和 时间戳
     *
     * @author HuWeihui
     * @since hui_project v1
     */
    @PostConstruct
    public void initEditableAvlidation() {
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
        if (initializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService) initializer.getConversionService();
            genericConversionService.addConverter(new RequestDateConvert());
        }
    }
}

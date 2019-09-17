package com.hui.cloud.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b><code>MybatisPlusConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/18 0:48.
 *
 * @author Gary.Hu
 */
@Configuration
@MapperScan("com.hui.cloud.*.*.mapper*")
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制
         paginationInterceptor.setLimit(100);
        return paginationInterceptor;
    }
}

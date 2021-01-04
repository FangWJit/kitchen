package com.dhf.kitchen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置文件
 * @Author : FangWanJun
 * @Date : created in 15:27 2020/11/5
 */
@Configuration
public class CorsConfig  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")   //添加映射
                .allowedOrigins("*")      //允许的起源
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")   // 允许的方法
                .allowCredentials(true)   // 是否允许证书
                .maxAge(3600)            // 准备访问前缓存持续的最大时间
                .allowedHeaders("*");    //允许的头
    }
}

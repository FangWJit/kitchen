package com.dhf.kitchen.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author : FangWanJun
 * @Date : created in 13:06 2020/11/4
 */

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.dhf.kitchen.system.pc.*.mapper","com.dhf.kitchen.base.ip.mapper"})
public class MybatisPlusConfig {

    // 性能分析拦截器
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    //  分页 插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(DbType.MYSQL.getDb());
        return paginationInterceptor;
    }

}

package com.dhf.kitchen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Date: 2020/4/17
 * @Author: zk
 * Swagger config
 */
@Configuration
@EnableSwagger2 // 开启swagger2
public class Swagger2Configuration {

    @Value(value = "${swagger.basePath}")
    private String basePackage;

    @Value(value = "${swagger.title}")
    private String title;

    @Value(value = "${swagger.description}")
    private String description;

    @Value(value = "${swagger.version}")
    private String version;

    @Value(value = "${swagger.enable}")
    private boolean enable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .enableUrlTemplating(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();
    }

}

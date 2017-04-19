package com.photovoltaic.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by wangchun on 2016/11/22.
 */
@Configuration
@EnableWebMvc //NOTE: Only needed in a non-springboot application
@EnableSwagger2
@ComponentScan(value = "com.photovoltaic.web.**", lazyInit = true)
public class SwaggerConfig {
    @Bean
    public Docket api() {
        Predicate<String> predicate1 = PathSelectors.regex("/servlet/.*");
        Predicate<String> predicate2 = PathSelectors.regex("/app/.*");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //.paths(PathSelectors.regex("/servlet/.*")) servlet、app and others
                .paths(PathSelectors.regex("/*/.*"))
                .build()
                .securitySchemes(newArrayList(apiKey()))
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("光伏项目在线API文档")
                .description("photovoltaic api")
                .version("1.0")
                .termsOfServiceUrl("http://terms-of-services.url")
                .license("")
                .licenseUrl("http://url-to-license.com")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("mykey", "api_key", "header");
    }

}

package com.globallogic.report.billing.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Created by sunny on 15/03/18.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.globallogic.report.billing.rest"))
                .paths(PathSelectors.ant("/app/*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "GlobalLogic Bill Prediction REST API",
                "The API's to get bill prediction for next month.",
                "API TOS",
                "Terms of service",
                new Contact("Sunny Verma", "www.globallogic.com", "sunnyvrm8@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}

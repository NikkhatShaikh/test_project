package com.explarity.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerClass {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(getInfo()).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();

    }

        private ApiInfo getInfo() {
            return new ApiInfo("Application_Name:Test_Spring_Application",
                    "This is test Application For Server",
                    "v1",
                    "terms of Service ",
                    new Contact("Nikkhat", "https://caprium.com/", "nikkhat.shaikh@caprium.com"),
                    "Licence of API'S",
                    "Api Licence URL",Collections.emptyList());
        }

//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "Application_Name:Test_Spring_Application",
//                "Some custom description of API.",
//                "API v1",
//                "Terms of service",
//                new Contact("John Doe", "https://caprium.com/", "nikkhat.shaikh@caprium.com"),
//                "License of API", "API license URL", Collections.emptyList());
//    }


    }



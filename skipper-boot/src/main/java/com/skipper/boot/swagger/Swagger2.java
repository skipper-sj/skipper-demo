package com.skipper.boot.swagger;

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
 * Created by shoujian on 2017/5/31.
 */
@Configuration  //通过注解来
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.skipper.web"))
                .paths(PathSelectors.any())
                .build();

//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("demo")
////                .genericModelSubstitutes(DeferredResult.class)
////              .genericModelSubstitutes(ResponseEntity.class)
////                .useDefaultResponseMessages(false)
////                .forCodeGeneration(false)
////                .pathMapping("/")
//                .select()
//                .paths(or(regex("/demo.*")))//过滤的接口
//                .build()
//                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("skipper`s APIs")
                .description("skipper的例子")
                .termsOfServiceUrl("暂无")
                .contact("learner skipper")
                .version("1.0.0")
                .build();
    }
}
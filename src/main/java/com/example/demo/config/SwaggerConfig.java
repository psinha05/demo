package com.example.demo.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@Configuration
@EnableSwagger2WebMvc

public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
	    .select()
	    .paths(PathSelectors.any())
	    .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
	    .build()
	     .apiInfo(apiDetails());
	}   
	
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Author Book API",
				"Sample API For Swagger Demo Application", 
				"1.0", 
				"Free to Use", 
				new springfox.documentation.service.Contact("Prashant Sinha", "www.tjatechnologies.com", "p@email.com"), 
				"API License", 
				"www.tjatechnologies.com",
				Collections.emptyList()
				);
	}
}

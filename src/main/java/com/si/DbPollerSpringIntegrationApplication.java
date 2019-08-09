package com.si;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAsync
@EnableSwagger2
@EnableTransactionManagement
@EnableIntegration
@SpringBootApplication
public class DbPollerSpringIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbPollerSpringIntegrationApplication.class, args);
	}
	
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()                                       
	      .apis(RequestHandlerSelectors.basePackage("com.si.api"))
	      .paths(PathSelectors.any())                     
	      .build();
	}

}

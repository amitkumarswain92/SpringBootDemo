package org.kms.app.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.google.common.base.Predicates.or;
@SpringBootApplication
@RestController
@EnableSwagger2
@ComponentScan(basePackages="org.kms.controller,org.kms.services")
public class AppRunner extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(AppRunner.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AppRunner.class);
	}
	
	@RequestMapping("/")
	public String test(){
		return "ETS APPLICATION SETUP IS SUCCESSFUL";
	}
	
	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("greetings")
                .apiInfo(apiInfo())
                .select() 
                .paths(regex("/.*"))
                //.paths(postPaths())
                .build();
        //.paths(regex("/*cou*"))
        //.paths(postPaths())
    }
	
	 private com.google.common.base.Predicate<String> postPaths(){
		return or(regex("/OrdersList"),regex("/OrderModuleSanityTest"),regex("/courseList"));
	} 
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .termsOfServiceUrl("")
                .contact("Munisekhar Naidu Kankanala")
                .license("Open Source")
                .licenseUrl("https://github.com/kmedhansh")
                .version("1.0")
                .build();
    }
	
}

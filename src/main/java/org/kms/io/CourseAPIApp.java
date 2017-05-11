package org.kms.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
//If controllers were written on same package where main class is return, then no need of component scan.
@ComponentScan(basePackages="org.kms.controller,org.kms.services")
public class CourseAPIApp {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CourseAPIApp.class, args);
	}


}

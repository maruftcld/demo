package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring")
@EntityScan(basePackages = "com.spring.model")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DemoApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

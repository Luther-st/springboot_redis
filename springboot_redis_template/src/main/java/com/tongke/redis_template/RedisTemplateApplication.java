package com.tongke.redis_template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RedisTemplateApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RedisTemplateApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		System.out.println("外部tomcat,chapter启动!");
		return application.sources(RedisTemplateApplication.class);
	}
}

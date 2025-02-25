package com.riegel.AutoWiring_07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AutoWiring07Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(AutoWiring07Application.class, args);

		Dev obj = context.getBean(Dev.class);
		
		obj.build();

	}

}

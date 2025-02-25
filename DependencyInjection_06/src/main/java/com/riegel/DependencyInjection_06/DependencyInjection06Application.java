package com.riegel.DependencyInjection_06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjection06Application {

	public static void main(String[] args) {
		// creates a container for the objects it creates of the classes
		ApplicationContext context = SpringApplication.run(DependencyInjection06Application.class, args);

		// old way: doesn't create obj in jvm
		// Dev obj = new Dev();
		// obj.build();

		Dev obj = context.getBean(Dev.class);
		obj.build();

	}

}

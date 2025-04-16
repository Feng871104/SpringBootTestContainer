package com.leon.testcontainer;

import org.springframework.boot.SpringApplication;

public class TestSpringBootTestContainerApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringBootTestContainerApplication::main)
				.with(TestcontainersConfiguration.class)
				.run(args);
	}

}

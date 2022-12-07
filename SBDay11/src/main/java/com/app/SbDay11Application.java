package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Batch 2"))
public class SbDay11Application {

	public static void main(String[] args) {
		SpringApplication.run(SbDay11Application.class, args);
	}

}

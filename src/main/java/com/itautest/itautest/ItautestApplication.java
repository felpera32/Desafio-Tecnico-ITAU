package com.itautest.itautest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@ConfigurationPropertiesScan

@SpringBootApplication
public class ItautestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItautestApplication.class, args);
	}

}

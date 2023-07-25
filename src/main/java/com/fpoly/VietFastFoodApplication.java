package com.fpoly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class VietFastFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(VietFastFoodApplication.class, args);
	}
}

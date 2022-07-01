package com.in28minutes.unittesting.unittesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.*;

//@SpringBootApplication
@SpringBootApplication
//		(exclude={DataSourceAutoConfiguration.class})
public class UnitTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingApplication.class, args);
	}

}

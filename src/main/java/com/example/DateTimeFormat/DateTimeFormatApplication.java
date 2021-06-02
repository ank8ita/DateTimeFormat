package com.example.DateTimeFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example"})
public class DateTimeFormatApplication {

	public static void main(String[] args) {
		SpringApplication.run(DateTimeFormatApplication.class, args);
	}

}

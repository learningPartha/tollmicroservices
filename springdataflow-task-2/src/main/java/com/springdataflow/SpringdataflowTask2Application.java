package com.springdataflow;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableTask
@SpringBootApplication
public class SpringdataflowTask2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataflowTask2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return result ->{
			System.out.println("Entered new cloud environment into Config DB!");
		};
	}

}

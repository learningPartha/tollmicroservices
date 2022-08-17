package com.queueintake;

import java.time.Instant;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.queueintake.model.FastPassToll;

@SpringBootApplication
public class TollIntakeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TollIntakeApplication.class, args);
	}
	
	@Bean
	public Consumer<FastPassToll> readTollCharge(){
		return value -> {
			System.out.println("Received message for  customer "+value.getFastPassId()+
					" at "+Instant.now().toString());
		};
	}
	
	/*@Bean
	public Consumer<FastPassToll> readTollChargeFast(){
		return value -> {
			System.out.println("Received message for {fast} customer "+value.getFastPassId()+
					" at "+Instant.now().toString());
		};
	}
	
	@Bean
	public Consumer<FastPassToll> readTollChargesSlow(){
		return value -> {
			System.out.println("Received message for {slow} customer "+value.getFastPassId()+
					" at "+Instant.now().toString());
		};
	}*/
	
	//@Bean
	public Function<FastPassToll,FastPassToll> processTollCharge(){
		return value ->{
			System.out.println("Processing message");
			value.setStatus("processed");
			return value;
		};
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Listening for messages");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();

	}

}

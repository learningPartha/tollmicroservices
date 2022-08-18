package com.springdataflow;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.springdataflow.config.TollReadingProperties;
import com.springdataflow.model.FastPassToll;

@EnableConfigurationProperties(TollReadingProperties.class)
@SpringBootApplication
public class ScoringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoringAppApplication.class, args);
	}

	@Autowired
	private TollReadingProperties tollProperties;
	
	@Bean
	public Function<FastPassToll, FastPassToll> assignscore(){
		return value ->{
			Integer fraudThreshold = tollProperties.getFraudThreshold();
			Integer fraudProbabilityScore=0;
			value.setFraud(false);
			
			System.out.println("Station id is "+value.getStationId());
			System.out.println("Fraud threshold is "+fraudThreshold);
			
			if(value.getStationId().equals("1001")) {
				//in real life pull from cache that stores constantly updated record
				fraudProbabilityScore = 30;
			}
			
			if(fraudProbabilityScore>fraudThreshold) {
				value.setFraud(true);
			}
			
			return value;
		};
	}
	
}

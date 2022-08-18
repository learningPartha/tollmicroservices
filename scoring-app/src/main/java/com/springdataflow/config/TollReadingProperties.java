package com.springdataflow.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties("fraud")
public class TollReadingProperties {

	private int fraudThreshold;

	public int getFraudThreshold() {
		return fraudThreshold;
	}

	public void setFraudThreshold(int fraudThreshold) {
		this.fraudThreshold = fraudThreshold;
	}
	
	
	
}

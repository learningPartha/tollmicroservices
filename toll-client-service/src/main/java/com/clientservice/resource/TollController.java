package com.clientservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.clientservice.model.TollData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TollController {

	@Autowired
	WebClient webClient;

	@GetMapping("/")
	public Mono<TollData> getLatestToll() {
		// call resource server
		Flux<TollData> response = this.webClient.get().uri("http://localhost:8086/api/tolldata").retrieve()
				.bodyToFlux(TollData.class);
		List<TollData> tollData = response.collectList().block();
		return Mono.just(tollData.get(0));
	}

}

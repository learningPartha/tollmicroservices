package com.pluralsight.tollrateui.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import com.pluralsight.tollrateui.model.TollRate;

import reactor.core.publisher.Mono;

@Controller
public class DashboardController {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private ReactiveCircuitBreakerFactory circuitBreakerFactory;

    @RequestMapping("/dashboard")
	public String GetTollRate(@RequestParam(defaultValue = "1000") Integer stationId, Model m) {

        //WebClient client = WebClient.create();

    	ReactiveCircuitBreaker rcb = circuitBreakerFactory.create("tollrate-cb");
    	
        /*TollRate rate = webClientBuilder.build().get()
            .uri("http://tollrate-service/tollrate/" + stationId)
            .retrieve()
            .bodyToMono(TollRate.class)
            .block();*/
    	
    	Mono<TollRate> rate = rcb.run(webClientBuilder.build().get()
                .uri("http://tollrate-service/tollrateslow/" + stationId)
                .retrieve()
                .bodyToMono(TollRate.class),
                throwable ->getDefaultRate() );
    	
		
		System.out.println("stationId: " + stationId);
		m.addAttribute("rate", rate.block());
		return "dashboard";
	}
    
    
    private Mono<TollRate> getDefaultRate(){
    	System.out.println("Fallback toll rate method called");
    	return Mono.just(new TollRate(0,2.00f,""));
    }
    
}

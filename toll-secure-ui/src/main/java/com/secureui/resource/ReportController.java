package com.secureui.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import com.secureui.model.TollData;

import reactor.core.publisher.Flux;

@Controller
public class ReportController {

	@Autowired
	private WebClient webClient;

	@RequestMapping("/")
	public String loadHome() {
		return "home";
	}

	@RequestMapping("/report")
	public String loadReport(Model m) {
		
		//call resource server
		Flux<TollData> response = this.webClient.get().uri("http://localhost:8086/api/tolldata").retrieve()
				.bodyToFlux(TollData.class);
		List<TollData> tollData = response.collectList().block();
		m.addAttribute("tollData", tollData);

		return "report";
	}

}

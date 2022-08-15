package com.resourceserver.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resourceserver.model.TollData;

@RestController
public class TollController {

	private List<TollData> tollData;
	
	public TollController() {
		tollData = new ArrayList<TollData>();
		tollData.add(new TollData("900","1VB4GHA","2022-08-15T07:35:42"));
		tollData.add(new TollData("901","BB40003","2022-08-15T07:35:50"));
		tollData.add(new TollData("902","B200VV4","2022-08-15T07:36:12"));
	}
	
	@RequestMapping("/api/tolldata")
	public List<TollData> getTollData(){
		return tollData;
	}
	
}
